package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {

	private final String command = "/update.prd";
	private final String getPage = "productUpdateForm";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(HttpSession session, @RequestParam("num") int num, Model model) {
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/update.prd?num="+num);
			return "redirect:/loginForm.me";
		} else {
			Product product = dao.getProduct(num);
			model.addAttribute("product",product);
			return getPage;
		}
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String doAction(@Valid Product product, BindingResult result) {
		Product prd = dao.getProduct(product.getNum());
		//System.out.println("새 이미지 : "+product.getImage());
		//System.out.println("이전 이미지 : "+prd.getImage());
		boolean newImg = true;
		if(product.getImage().equals("")) {
			newImg = false; // 새로 이미지 추가 하지 않은 경우
			product.setImage(prd.getImage());
		}
		
		if(!result.hasErrors()) { // 유효성 검사 오류 없음
			int cnt = dao.updateProduct(product);
			if(cnt == 1) { // 수정 성공
				if(!product.getImage().equals(prd.getImage())) {
					//새로 이미지 추가 및 이전 이미지 삭제
					//System.out.println("이미지 변화:"+!product.getImage().equals(prd.getImage()));
					if(newImg) { // 새로 이미지 추가
						String uploadPath = servletContext.getRealPath("/resources");
						//System.out.println("uploadPath: "+uploadPath);
						// C:\sw\Spring_sdr\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\19_Spring_Mybatis_Products\resources
						File delFile = new File(uploadPath+File.separator+prd.getImage());
						delFile.delete(); // 이전 이미지 삭제
		
						MultipartFile multi = product.getUpload();
						
						File f = new File(uploadPath+"\\"+product.getImage());
						try {
							multi.transferTo(f);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return gotoPage;
			}
		}
		return getPage;
	}
	
}
