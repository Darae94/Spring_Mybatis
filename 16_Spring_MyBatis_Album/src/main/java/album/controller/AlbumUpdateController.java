package album.controller;

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

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {

	private final String command = "/update.ab";
	private final String getPage = "albumUpdateForm";
	private final String gotoPage = "redirect:/list.ab";

	@Autowired
	AlbumDao dao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value="num", required = true) int num,
						@RequestParam(value="pageNumber", required = true) int pageNumber,
						Model model) {
		
		AlbumBean album = dao.getAlbum(num);
		System.out.println("AlbumUpdateController album.getTitle(): "+album.getTitle());
		model.addAttribute("album",album);
		model.addAttribute("pageNumber",pageNumber);
		
		return getPage; // albumUpdateForm.jsp
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam(value="pageNumber", required = true) int pageNumber,
								@ModelAttribute("album") @Valid AlbumBean album,
								BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		} else {
			dao.updateAlbum(album);
			mav.setViewName(gotoPage+"?pageNumber="+pageNumber); //redirect:/list.ab?pageNumber=2
		}
		return mav;
	}
	
}
