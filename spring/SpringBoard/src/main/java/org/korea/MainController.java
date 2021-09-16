package org.korea;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
	@RequestMapping("boardList.do")
	public String boardMain() {
		return "board/board_list";
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
	@RequestMapping("idCheck.do")
	public String idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemberDTO dto = memberService.idCheck(id);
		JSONObject object = new JSONObject();
		System.out.println(dto);
		if(dto == null) 
			object.put("result",true);
		else
			object.put("result",false);
		response.getWriter().write(object.toString());	
		return null;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping("memberUpdateView.do")
	public String memberUpdateView(HttpSession session) {
		return "member/member_update";
	}
	@RequestMapping("memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		MemberDTO dto = new MemberDTO(id,pass,name,age,null, 0, null);
		int count = memberService.updateMember(dto);
		if(count == 0) {
			request.getSession().invalidate();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('없는 회원 입니다. 확인 후 다시 수행해 주세요');"
					+ "location.href = '/';</script>");
			return null;
		}
		
		return "board/board_list";
	}
}











