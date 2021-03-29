package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDetailController {

	private final String command = "/detail.prd";
	private final String getPage = "productDetail";
	
	@Autowired
	ProductDao dao;
	
	@RequestMapping(command)
	public String doAction(
				@RequestParam("num") int num,
				Model model
			) {
		Product product = dao.getProduct(num);
		model.addAttribute("product",product);
		return getPage;
	}
	
}
