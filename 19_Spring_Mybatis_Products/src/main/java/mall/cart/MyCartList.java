package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList { // 장바구니

	private Map<Integer, Integer> orderlists = null; // 상품번호, 주문수량
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		//System.out.println("addOrder: "+orderlists.containsKey(pnum));
		if(orderlists.containsKey(pnum)) { // 있으면 누적
			oqty += orderlists.get(pnum);
		}
		
		orderlists.put(pnum, oqty);
	}
	
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}
	
}
