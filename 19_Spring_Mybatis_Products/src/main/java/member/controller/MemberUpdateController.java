package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {
	
	private final String command = "/update.me";
	private final String getPage = "memberUpdateForm";
	private final String gotoPage = "redirect:/list.me";
	
	@Autowired
	MemberDao dao;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
				@RequestParam("id") String id,
				@RequestParam("pageNumber") int pageNumber,
				Model model
			) {
		Member mb = dao.getMember(id);
		System.out.println("pageNumber: "+pageNumber);
		model.addAttribute("member",mb);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("pageNumber") int pageNumber, @Valid Member member, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		} else {
			int cnt = dao.updateMember(member);
			if(cnt ==1) {
				mav.setViewName(gotoPage);
			} else {
				mav.setViewName(getPage);
			}
			//System.out.println("update POST =>"+cnt);
		}
		return mav;
	}

}
