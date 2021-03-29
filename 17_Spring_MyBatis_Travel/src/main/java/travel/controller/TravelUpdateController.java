package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	private final String command = "/update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao dao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(
			@RequestParam(value="num",required=true) int num,
			@RequestParam(value="pageNumber",required=true) int pageNumber,
			Model model
			) {
		TravelBean travel = dao.getTravel(num);
		model.addAttribute("travel",travel);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("travel") @Valid TravelBean travel,
			BindingResult result,
			@RequestParam(value="pageNumber",required=true) int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			//System.out.println("유효성검사 오류");
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		} else {
			int cnt = -1;
			cnt = dao.updateTravel(travel);
			if(cnt == 1) {
				mav.addObject("pageNumber",pageNumber);
				mav.setViewName(gotoPage);
			} else {
				mav.addObject("pageNumber",pageNumber);
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
	
}
