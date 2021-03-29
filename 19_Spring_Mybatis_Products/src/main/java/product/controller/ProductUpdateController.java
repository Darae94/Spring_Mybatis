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
		//System.out.println("�� �̹��� : "+product.getImage());
		//System.out.println("���� �̹��� : "+prd.getImage());
		boolean newImg = true;
		if(product.getImage().equals("")) {
			newImg = false; // ���� �̹��� �߰� ���� ���� ���
			product.setImage(prd.getImage());
		}
		
		if(!result.hasErrors()) { // ��ȿ�� �˻� ���� ����
			int cnt = dao.updateProduct(product);
			if(cnt == 1) { // ���� ����
				if(!product.getImage().equals(prd.getImage())) {
					//���� �̹��� �߰� �� ���� �̹��� ����
					//System.out.println("�̹��� ��ȭ:"+!product.getImage().equals(prd.getImage()));
					if(newImg) { // ���� �̹��� �߰�
						String uploadPath = servletContext.getRealPath("/resources");
						//System.out.println("uploadPath: "+uploadPath);
						// C:\sw\Spring_sdr\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\19_Spring_Mybatis_Products\resources
						File delFile = new File(uploadPath+File.separator+prd.getImage());
						delFile.delete(); // ���� �̹��� ����
		
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
