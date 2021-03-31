package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList { // ��ٱ���

	private Map<Integer, Integer> orderlists = null; // ��ǰ��ȣ, �ֹ�����
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		//System.out.println("addOrder: "+orderlists.containsKey(pnum));
		if(orderlists.containsKey(pnum)) { // ������ ����
			oqty += orderlists.get(pnum);
		}
		
		orderlists.put(pnum, oqty);
	}
	
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}
	
}
