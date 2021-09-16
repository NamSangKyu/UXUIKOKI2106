package org.korea;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.korea.dto.MemberDTO;
import org.korea.service.BoardService;
import org.korea.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private BoardService boardService;
	private MemberService memberService;
	
	public MainController(BoardService boardService, MemberService memberService) {
		super();
		this.boardService = boardService;
		this.memberService = memberService;
	}

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDTO dto = memberService.login(id,pass);
		
		if(dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디 비밀번호 확인하세요'); history.back();</script>");
			return null;
		}else {
			request.getSession().setAttribute("client", dto);
			return "board/board_list";
		}
		
	}
	@RequestMapping("registerView.do")
	public String registerView() {
		return "member/member_register";
	}
	@RequestMapping("memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		MemberDTO dto = new MemberDTO(id,pass,name,age,gender , 0, null);
		int count = memberService.insertMember(dto);
		
		if(count == 0) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디가 중복되었습니다.'); history.back();</script>");
			return null;
		}
		request.getSession().setAttribute("client", dto);
		return "board/board_list";
	}
	
}











