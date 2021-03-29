package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDetailController {

	private final String command = "/detail.tv";
	private final String getPage = "travelDetailView";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam(value="num", required=true) int num,
			@RequestParam(value="pageNumber", required=true) int pageNumber,
			Model model) {
		TravelBean travel = travelDao.getTravel(num);
		//System.out.println("TravelDetailController num : "+travel.getNum());
		model.addAttribute("travel",travel);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	
}
