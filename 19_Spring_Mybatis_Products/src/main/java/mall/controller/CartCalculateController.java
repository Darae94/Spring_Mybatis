package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.Member;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetail;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {

	private final String command = "/calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private MemberDao mDao;
	// 포인트 적립
	@Autowired
	private ProductDao pDao;
	// 재고수량 감소
	@Autowired
	private OrderDao oDao;
	
	@Autowired
	private OrderDetailDao odDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		// 장바구니
		Map<Integer, Integer> maplist = mycart.getAllOrderLists();
		// 상품번호, 주문수량
		// 2, 3
		// 5, 7
		Set<Integer> keylist = maplist.keySet();
		System.out.println("keylist: "+keylist); // [2, 5]
		
		Member member = (Member) session.getAttribute("loginInfo");
		String mid = member.getId();
		int cnt = oDao.insertData(mid);
		
		int maxOid = oDao.getMaxOrderOid();
		System.out.println("maxOid: "+maxOid);
		
		for(Integer pnum : keylist) {
			Integer oqty = maplist.get(pnum); // 2:3, 5:7
			OrderDetail odetail = new OrderDetail();
			odetail.setOid(maxOid);
			odetail.setPnum(pnum);
			odetail.setQty(oqty);
			// orderDetail 추가
			odDao.insertData(odetail);
			// 재고수량 감소
			pDao.stockDecrease(pnum, oqty);
		}
		mDao.updateMpoint(mid,100);
		
		return gotoPage;
	}
	
}
