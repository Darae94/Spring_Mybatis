package mall.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartListController {

	private final String command = "/list.mall";
	private final String getPage = "mallList";
	
	@Autowired
	private ProductDao pDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		Map<Integer, Integer> maplist = mycart.getAllOrderLists(); // 장바구니 통째로 리턴받음
		
		Set<Integer> keylist = maplist.keySet(); // 상품번호만 담김
		System.out.println("장바구니 상품 갯수: "+keylist.size());
		
		ArrayList<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		
		int totalAmount = 0;
		for(Integer pnum :  keylist) {
			Product product = pDao.getProduct(pnum);
			
			ShoppingInfo sh = new ShoppingInfo();
			sh.setPnum(pnum);
			sh.setPname(product.getName());
			
			//int oqty = maplist.get(pnum);
			//sh.setOqty(oqty);
			sh.setOqty(maplist.get(pnum));
			
			sh.setPrice(product.getPrice());
			//int amount = product.getPrice() * sh.getOqty();
			//.setAmount(amount);
			sh.setAmount(product.getPrice() * sh.getOqty());
			
			totalAmount += product.getPrice() * sh.getOqty();
			
			shoplists.add(sh);
		}
		
		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		
		return getPage;
	}
	
}
