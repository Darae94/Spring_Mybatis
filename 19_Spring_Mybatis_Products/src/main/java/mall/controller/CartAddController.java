package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mall.cart.MyCartList;
import product.model.Product;

// productDetail.jsp => 주문하기 클릭
@Controller
public class CartAddController {
	
	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall"; // => CartListController
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(Product product, HttpSession session) {
		
		int num = product.getNum();
		int oqty = product.getOrderqty();
		// 로그인 했는지 확인
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/detail.prd?num="+num);
			return "redirect:/loginForm.me";
		} else {
			MyCartList mycart = (MyCartList) session.getAttribute("mycart");
			System.out.println("mycart: " + mycart);
			
			if(mycart == null) { // 장바구니가 없었을때
				mycart = new MyCartList();
			}
			mycart.addOrder(num, oqty); // 장바구니 상품 추가
			session.setAttribute("mycart", mycart);
			return gotoPage;
		}
	}
	
}
