package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	
	private final String command = "/insert.ab";
	private final String getPage = "albumInsertForm";
	private final String gotoPage = "redirect:/list.ab";
		
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doActionGet() {
		return getPage; // form 요청
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doActionPost(
							//@RequestParam("title") String title,
							//@RequestParam("singer") String singer,
							//@RequestParam("price") String price,
							//@RequestParam("day") String day
							@Valid AlbumBean album, BindingResult result) {
		//AlbumBean album = new AlbumBean();
		//album.setTitle(title);
		//album.setSinger(singer);
		//album.setPrice(price);
		//album.setDay(day);
		// 생략 시킨 9줄이 한줄의 command객체로 입력 가능
		System.out.println("doActionPost result.hasErrors() : "+result.hasErrors());
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { // 누락, 처리 하는데 오류가 있음
			System.out.println("유효성 검사 오류입니다.");
			mav.setViewName(getPage);
			return mav;
		}
		dao.insertAlbum(album);
		mav.setViewName(gotoPage);
		return mav;
	}
	
}
