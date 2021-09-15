package org.korea;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.korea.dto.MemberDTO;
import org.korea.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private MemberService service;
	
	//자동으로 AutoWire가 적용되어있어서 생성시 자동으로 역주입 해줌(Bean) 등록된 클래스들을
	public MainController(MemberService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String main() {
		System.out.println("메인 페이지로 이동");
		return "main";
	}

	@RequestMapping("/login.do")
	//public String login(@RequestParam("id")String id, @RequestParam("pass")String pass, HttpSession session ) {
	public String login(HttpServletRequest request, HttpSession session ) {
		ArrayList<MemberDTO> list = null;
		if(session.getAttribute("dto") != null) {
			list = service.selectAllMember();
			request.setAttribute("list", list);
			return "member_manager";
		}
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDTO dto = service.login(id, pass);
		session.setAttribute("dto", dto);
		list = service.selectAllMember();
		request.setAttribute("list", list);
		return "member_manager";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
}











