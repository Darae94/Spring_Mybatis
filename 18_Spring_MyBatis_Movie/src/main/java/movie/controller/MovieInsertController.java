package movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieInsertController {

	private final String command = "/insert.mv";
	private final String getPage = "movieInsertForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(
						@ModelAttribute("movie") @Valid MovieBean movie,
						BindingResult result
					) {
		if(result.hasErrors()) {
			return getPage;
		}
		dao.insertMovie(movie);
		return gotoPage;
	}
}
