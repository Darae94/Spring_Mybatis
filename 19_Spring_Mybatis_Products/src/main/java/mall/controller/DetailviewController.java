package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import product.model.CompositeDao;

@Controller
public class DetailviewController {

	private final String command = "/detailView.mall";
	private final String getPage = "shopDetailList";
	
	@Autowired
	CompositeDao cDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("oid") int oid, Model model) {
		List<ShoppingInfo> lists = cDao.showDetail(oid);
		model.addAttribute("lists", lists);
		model.addAttribute("oid", oid);
		return getPage;
	}
	
}

/*
SQL> select num, name, price from products;

NUM NAME            PRICE
--- ---------- ----------
 19 ���ڼ���         5000
 20 ������           3000
  1 �Һ���           1000
  2 ũ����           2000
  3 �ݶ�             3000
  4 ���̴�           4000
  5 ȯŸ             5000
  6 ġŲ             5000
  8 �����           4000
 10 �������ݸ�       3000
 16 ������           3000
 21 �����ٷ�         5000
 
 SQL> select * from orderdetails order by odid;

      ODID        OID       PNUM        QTY
---------- ---------- ---------- ----------
         1          1         19          2
         2          1         21          1
         3          2         19          3
         4          2         21          1
         
select p.num pnum, p.name pname, od.qty, p.price, p.price * od.qty as amount
from orderdetails od inner join products p
on od.pnum = p.num and od.oid = 2;

*/