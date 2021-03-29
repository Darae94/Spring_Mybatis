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
	
	// ��ǰ �߰��Ϸ��� �ϴµ� �α����� �ȵǾ �̵���
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
			System.out.println("�������� �ʴ� ȸ��");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('�ش� ���̵� �������� �ʽ��ϴ�.');");
			pw.print("</script>");
			pw.flush();
		} else {
			// id�� ������
			if(member.getPassword().equals(password)) {
				// password ��ġ
				session.setAttribute("loginInfo", member);
				// => ��ǰ �߰� ȭ��(insert.prd => ProductInsertController => ProductInsertForm.jsp)
				String destination = (String) session.getAttribute("destination");
				System.out.println("�α��� ����: "+destination);
				// destination = "redirect:/insert.prd"
				return destination;
			} else {
				// password ����ġ
				pw.print("<script type='text/javascript'>");
				pw.print("alert('����� ��ġ���� �ʽ��ϴ�.');");
				pw.print("</script>");
				pw.flush();
			}
		}
		
		return getPage;
	}
	
}
