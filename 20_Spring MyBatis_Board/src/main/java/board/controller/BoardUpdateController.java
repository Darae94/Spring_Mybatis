package board.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {

	private final String command = "/update.bd";
	private final String getPage = "updateForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
				@RequestParam("num") int num,
				@RequestParam("pageNumber") String pageNumber,
				Model model
			) {
		BoardBean bean = bDao.getBoard(num);
		model.addAttribute("bean", bean);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(
				@RequestParam("pageNumber") String pageNumber,
				@ModelAttribute("bean") @Valid BoardBean bb,
				BindingResult result,
				HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(!result.hasErrors()) {
			int cnt = bDao.updateBoard(bb);
			if(cnt == 1) {
				mav.setViewName(gotoPage);
			} else {
				pw.print("<script type='text/javascript'>");
				pw.print("alert('비밀번호가 일치하지 않습니다.');");
				pw.print("</script>");
				pw.flush();
			}
		}
		return mav;
	}
	
}
