package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {

	private final String command = "/detail.mv";
	private final String getPage = "movieDetail";
	
	@Autowired
	private MovieDao dao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
				@RequestParam(value = "num", required = true) int num,
				@RequestParam(value = "pageNumber", required = true) int pageNumber,
				Model model
			) {
		MovieBean movie = dao.getMovie(num);
		model.addAttribute("movie",movie);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}

}
