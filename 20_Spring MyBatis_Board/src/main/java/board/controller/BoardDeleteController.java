package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardDao;

@Controller
public class BoardDeleteController {

	private final String command = "/delete.bd";
	private final String getPage = "deleteForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
				@RequestParam("num") String num,
				@RequestParam("pageNumber") String pageNumber,
				Model model
			) {
		model.addAttribute("num", num);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(
				@RequestParam("num") String num,
				@RequestParam("passwd") String passwd,
				@RequestParam("pageNumber") String pageNumber,
				HttpServletResponse response,
				Model model
			) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("passwd", passwd);
		int cnt = bDao.deleteBoard(map);
		//System.out.println(num+"/"+passwd+"/pageNumber=>"+pageNumber+">>"+cnt);
		model.addAttribute("num", num);
		model.addAttribute("pageNumber", pageNumber);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(cnt == 1) {
			return gotoPage;
		} else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('비밀번호가 일치하지 않습니다.');");
			pw.print("</script>");
			pw.flush();
			return getPage;
		}
	}
	
}
