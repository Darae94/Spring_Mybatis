package member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	
	private final String command = "/loginForm.me";
	private final String getPage = "memberLoginForm";
	
	@Autowired
	MemberDao dao;
	
	// 상품 추가하려고 하는데 로그인이 안되어서 이동됨
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction(
				@RequestParam("id") String id,
				@RequestParam("password") String password,
				HttpServletResponse response,
				HttpSession session
			) throws Exception {
		Member member = dao.getMember(id);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		if(member == null) {
			System.out.println("존재하지 않는 회원");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('해당 아이디가 존재하지 않습니다.');");
			pw.print("</script>");
			pw.flush();
		} else {
			// id는 존재함
			if(member.getPassword().equals(password)) {
				// password 일치
				session.setAttribute("loginInfo", member);
				// => 상품 추가 화면(insert.prd => ProductInsertController => ProductInsertForm.jsp)
				String destination = (String) session.getAttribute("destination");
				System.out.println("로그인 성공: "+destination);
				// destination = "redirect:/insert.prd"
				return destination;
			} else {
				// password 불일치
				pw.print("<script type='text/javascript'>");
				pw.print("alert('비번이 일치하지 않습니다.');");
				pw.print("</script>");
				pw.flush();
			}
		}
		
		return getPage;
	}
	
}
