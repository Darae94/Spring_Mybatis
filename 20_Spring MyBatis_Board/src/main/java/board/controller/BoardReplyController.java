package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
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
public class BoardReplyController {

	private final String command = "/reply.bd";
	private final String getPage = "replyForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
				@RequestParam("pageNumber") String pageNumber,
				BoardBean board,
				Model model
			) {
		//System.out.println(board.getRef());
		//System.out.println("form>>"+board.getReStep());
		//System.out.println(board.getReLevel());
		model.addAttribute("board",board);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
				@RequestParam("pageNumber") String pageNumber,
				@ModelAttribute("board") @Valid BoardBean board,
				BindingResult result,
				HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("board",board);
		//System.out.println(board.getRef());
		//System.out.println("post>>"+board.getReStep());
		//System.out.println(board.getReLevel());
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		} else {
			Timestamp regDate = new Timestamp(System.currentTimeMillis());
			String ip = request.getRemoteAddr();
			board.setRegDate(regDate);
			board.setIp(ip);
			bDao.insertReply(board);
			mav.setViewName(gotoPage);
		}
		return mav;
	}
	
}
