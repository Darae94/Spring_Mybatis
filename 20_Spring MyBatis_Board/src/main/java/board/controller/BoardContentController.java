package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardContentController {

	private final String command = "/content.bd";
	private final String getPage = "content";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(command)
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
	
}
