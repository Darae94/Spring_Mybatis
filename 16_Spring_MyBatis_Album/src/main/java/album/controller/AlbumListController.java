package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {

	private final String command = "/list.ab"; // final 사용 이유 : 절대 변하지 않는 값으로 사용해야함!
	private final String getPage = "albumList"; // /WEB-INF/album/albumList.jsp
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam(value="whatColumn",required = false) String whatColumn,
								@RequestParam(value="keyword",required = false) String keyword,
								@RequestParam(value="pageNumber",required = false) String pageNumber,
								@RequestParam(value="pageSize",required = false) String pageSize,
								HttpServletRequest request) {
		// required = false 역할 : request가 꼭 넘어오지 않을 수도 있다는 의미
		System.out.println("whatColumn: "+whatColumn);
		System.out.println("keyword: "+keyword);
		System.out.println("pageNumber: "+pageNumber);
		System.out.println("pageSize: "+pageSize);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); // title, singer, null
		map.put("keyword", "%"+keyword+"%"); // %다%, %레드%, %null%
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount: "+totalCount);
		
		String url = request.getContextPath() + command; // ex/list.ab
		System.out.println("url:"+url); // url:/ex/list.ab
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		System.out.println("pageInfo.getOffset():"+pageInfo.getOffset()); // getOffset() : 건너뛰는 레코드 개수
		
		List<AlbumBean> lists = albumDao.getAlbumList(pageInfo,map);
		//System.out.println("AlbumListcontroller lists.size(): "+lists.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists",lists);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount",totalCount);
		mav.setViewName(getPage);
		return mav;
	}
	
}
