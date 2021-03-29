package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	
	private final String command = "/delete.prd";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		// 웹서버 폴더에서 먼저 삭제!
		Product prd = dao.getProduct(num); // prd.getImage()
		
		String delPath = servletContext.getRealPath("/resources");
		System.out.println(delPath);
		//
		
		File delFile = new File(delPath+File.separator+prd.getImage());
		delFile.delete();
		
		// 테이블에서 삭제
		dao.deleteProduct(num);
		
		model.addAttribute("pageNumber",pageNumber);
		return gotoPage;
	}

}
