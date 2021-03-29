package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {

	private final String command = "/delete.me";
	private final String getPage = "redirect:/list.me";
	
	@Autowired
	MemberDao dao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("id") String id) {
		dao.deleteMember(id);
		return getPage;
	}
	
}
