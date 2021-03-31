package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mall.cart.MyCartList;
import product.model.Product;

// productDetail.jsp => �ֹ��ϱ� Ŭ��
@Controller
public class CartAddController {
	
	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall"; // => CartListController
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Product product, HttpSession session) {
		
		int num = product.getNum();
		int oqty = product.getOrderqty();
		// �α��� �ߴ��� Ȯ��
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/detail.prd?num="+num);
			return "redirect:/loginForm.me";
		} else {
			MyCartList mycart = (MyCartList) session.getAttribute("mycart");
			System.out.println("mycart: " + mycart);
			
			if(mycart == null) { // ��ٱ��ϰ� ��������
				mycart = new MyCartList();
			}
			mycart.addOrder(num, oqty); // ��ٱ��� ��ǰ �߰�
			session.setAttribute("mycart", mycart);
			return gotoPage;
		}
	}
	
}
