package product.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mall.cart.ShoppingInfo;
import member.model.Member;
import order.model.Order;

@Component("myCompositeDao")
public class CompositeDao {

	private String namespace = "product.model.Composite."; // composite.xml
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Order> getOrder(Member loginInfo) {
		List<Order> lists = new ArrayList<Order>();
		lists = sqlSessionTemplate.selectList(namespace+"GetOrder", loginInfo.getId());
		return lists;
	}

	public List<ShoppingInfo> showDetail(int oid) {
		List<ShoppingInfo> lists = new ArrayList<ShoppingInfo>();
		lists = sqlSessionTemplate.selectList(namespace+"ShowDetail", oid);
		return lists; // DetailviewController로 돌아감
	}
	
}
