package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import order.model.Order;
import product.model.CompositeDao;

@Controller
public class OrderMallController {

	private final String command = "/order.mall";
	private final String gotoPage = "shopList";
	
	@Autowired
	CompositeDao cDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/loginForm.me";
		}
		List<Order> lists = cDao.getOrder(loginInfo);
		session.setAttribute("lists", lists);
		return gotoPage;
	}
	
}
