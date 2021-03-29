package movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

@Controller
public class MovieListController {

	private final String command = "/list.mv";
	private final String getPage = "movieList";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn", required=false) String whatColumn,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="pageSize", required=false) String _pageSize,
			@RequestParam(value="pageNumber", required=false) String _pageNumber,
			HttpServletRequest request
			) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = dao.getCountMovie(map);
		String url = request.getContextPath()+command;
		
		Paging pageInfo = new Paging(_pageNumber, _pageSize, totalCount, url, whatColumn, keyword);
		
		List<MovieBean> lists = dao.getMovieList(pageInfo, map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
	
}
