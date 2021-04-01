package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {

	private final String command = "/insert.bd";
	private final String getPage = "writeForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(@ModelAttribute("bb") @Valid BoardBean bb,
			BindingResult result,
			HttpServletRequest request) {
		if(!result.hasErrors()) {
			Timestamp regDate = new Timestamp(System.currentTimeMillis());
			String ip = request.getRemoteAddr();
			bb.setRegDate(regDate);
			bb.setIp(ip);
			System.out.println(bb.getReLevel());
			System.out.println(bb.getIp());
			System.out.println(bb.getWriter());
			int cnt = bDao.insertBoard(bb);
			if(cnt == 1) {
				return gotoPage;
			}
		}
		//return null;
		return getPage;
	}
	
}
