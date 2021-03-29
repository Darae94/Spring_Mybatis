package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductListController {
	
	private final String command= "/list.prd";
	private final String getPage = "productList"; // /WEB-INF/product/productList.jsp
	
	@Autowired
	ProductDao dao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
				@RequestParam(value = "whatColumn", required = false) String whatColumn,
				@RequestParam(value = "keyword", required = false) String keyword,
				@RequestParam(value = "pageNumber", required = false) String _pageNumber,
				@RequestParam(value = "pageSize", required = false) String _pageSize,
				HttpServletRequest request
			) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		System.out.println(whatColumn+"/"+keyword);
		int totalCount = dao.getTotalCount(map);
		String url = request.getContextPath() + command;
		System.out.println(totalCount+", "+url);
		
		Paging pageInfo = new Paging(_pageNumber, _pageSize, totalCount, url, whatColumn, keyword);

		List<Product> lists = dao.getProductList(pageInfo, map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
	
}
