package movie.controller;

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

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieUpdateController {

	private final String command = "/update.mv";
	private final String getPage = "movieUpdateForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
				@RequestParam("num") int num,
				@RequestParam("pageNumber") int pageNumber,
				Model model
			) {
		MovieBean movie = dao.getMovie(num);
		model.addAttribute("movie", movie);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
				@ModelAttribute("movie") @Valid MovieBean movie,
				BindingResult result,
				@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		} else {
			int cnt = -1;
			cnt = dao.updateMovie(movie);
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
