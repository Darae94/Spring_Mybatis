package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {
	
	private final String command = "/list.me";
	private final String getPage = "memberList";
	
	@Autowired
	private MemberDao dao;
	
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
		//System.out.println("MemberListController => "+whatColumn+"/"+keyword);
		int totalCount = dao.getTotalCount(map);
		String url = request.getContextPath() + command;
		//System.out.println(totalCount+", "+url);
		
		Paging pageInfo = new Paging(_pageNumber, _pageSize, totalCount, url, whatColumn, keyword);

		List<Member> lists = dao.getMemberList(pageInfo, map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
	
}
