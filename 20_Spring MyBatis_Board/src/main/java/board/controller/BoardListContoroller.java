package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListContoroller {

	private final String command = "/list.bd";
	private final String getPage = "list";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(command)
	public String doAction(
				@RequestParam(value="whatColumn", required=false) String whatColumn,
				@RequestParam(value="keyword", required=false) String keyword,
				@RequestParam(value="pageNumber", required=false) String _pageNum,
				@RequestParam(value="pageSize", required=false) String _pageSize,
				HttpServletRequest request
			) {
		//System.out.println("list");
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", keyword);
		
		int totalCount = bDao.getCountBoard(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(_pageNum, _pageSize, totalCount, url, whatColumn, keyword);
		
		List<BoardBean> lists = bDao.getAllBoard(pageInfo, map);
		request.setAttribute("lists", lists);
		request.setAttribute("pageInfo", pageInfo);
		
		return getPage;
	}
	
}
