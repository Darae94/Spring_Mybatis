package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductInsertController {

	private final String command = "/insert.prd";
	private final String getPage = "productInsertForm";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao dao;

	@Autowired
	ServletContext sevletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		// 변수 지정 하지 않고 진행하는 것도 가능
		// loginInfo - session은 MemberLoginController에서 설정
		// if(session.getAttribute("loginInfo") == null)
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		System.out.println("loginInfo: " + loginInfo);
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.me";
		} else {
			return getPage; // 상품 추가 화면
		}
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(
				@Valid Product product, BindingResult result
			) {
		String image = product.getImage();
		System.out.println("PIC image:"+image);
		
		System.out.println("servletContext: "+sevletContext);
		System.out.println("/: "+sevletContext.getRealPath("/"));
		System.out.println("/resources: "+sevletContext.getRealPath("/resources"));
		// 
		
		String uploadPath = sevletContext.getRealPath("/resources");
		
		System.out.println("result.hasErrors():"+result.hasErrors());
		
		ModelAndView mav = new ModelAndView();
		
		MultipartFile multi = product.getUpload();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		} else {
			int cnt = dao.insertProduct(product);
			if(cnt == 1) {
				File f = new File(uploadPath+"\\"+image);
				
				try {
					multi.transferTo(f);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				mav.setViewName(gotoPage);
			} else {
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
	
}
