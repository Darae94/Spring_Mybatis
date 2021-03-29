package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {

	private final String command = "/list.tv";
	private final String getPage = "travelList";

	@Autowired
	private TravelDao travelDao ;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request) {
		
		System.out.println(whatColumn);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn); // whatColumn = null, all, area, style
		map.put("keyword", "%"+keyword+"%"); // keyword = %null%, %유럽% ,%패키지%
		
		int totalCount = travelDao.getTotalCount(map);
		System.out.println(totalCount);
		
		String url = request.getContextPath() + command; // /ex/list.tv
		
		Paging pageInfo = 
				new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<TravelBean> lists = travelDao.getTravelList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
}




