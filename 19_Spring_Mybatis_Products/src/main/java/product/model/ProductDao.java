package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myProductDao")
public class ProductDao {

	private String namespace = "product.model.Product.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+"GetTotalCount", map);
		return cnt;
	}
	
	public List<Product> getProductList(Paging pageInfo, Map<String, String> map) {
		List<Product> lists = new ArrayList<Product>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+"GetProductList", map, rowBounds);
		return lists;
	}

	public int insertProduct(Product product) {
		int cnt = sqlSessionTemplate.insert(namespace+"InsertProduct", product);
		return cnt;
	}

	public Product getProduct(int num) {
		Product pd = sqlSessionTemplate.selectOne(namespace+"GetProduct", num);
		return pd;
	}

	public void deleteProduct(int num) {
		sqlSessionTemplate.delete(namespace+"DeleteProduct", num);
	}

	public int updateProduct(Product product) {
		int cnt = sqlSessionTemplate.update(namespace+"UpdateProduct",product);
		return cnt;
	}

	public void stockDecrease(Integer pnum, Integer oqty) {
		Product product = new Product();
		product.setNum(pnum);
		product.setStock(oqty);
		sqlSessionTemplate.update(namespace+"StockDecrease", product);
	}
	
}
