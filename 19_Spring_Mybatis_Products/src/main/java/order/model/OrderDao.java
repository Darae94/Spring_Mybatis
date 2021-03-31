package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDao")
public class OrderDao {

	private String namespace = "order.model.Order.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insertData(String mid) {
		int cnt = sqlSessionTemplate.insert(namespace+"InsertData", mid);
		return cnt;
	}

	public int getMaxOrderOid() {
		int cnt = sqlSessionTemplate.selectOne(namespace+"GetMaxOrderOid");
		return cnt;
	}
	
}
