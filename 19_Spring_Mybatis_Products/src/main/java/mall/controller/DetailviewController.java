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
 19 초코송이         5000
 20 오오오           3000
  1 소보루           1000
  2 크림빵           2000
  3 콜라             3000
  4 사이다           4000
  5 환타             5000
  6 치킨             5000
  8 새우깡           4000
 10 가나초콜릿       3000
 16 가나다           3000
 21 가나다로         5000
 
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