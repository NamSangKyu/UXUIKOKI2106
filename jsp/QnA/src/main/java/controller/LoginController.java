package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		//로그인
		MemberDTO dto = MemberService.getInstance().login(id,pass);
		ModelAndView view = null;
		//로그인이 정상적으로 수행 되었는지 여부
		if(dto == null) {
			response.getWriter().write("<script>alert('로그인 실패 아이디와 비번을 확인하세요');"
					+ "history.back();</script>");
		}else {
			//로그인한 클라이언트가 관리자인지 또는 일반 회원인지 구분
			System.out.println(dto.getName()+"님 로그인 - "+dto.getGrade());
			if(dto.getGrade().equals("ADMIN"))
				view = new ModelAndView("adminMain.do", true);
			else
				view = new ModelAndView("memberMain.do", true);
			request.getSession().setAttribute("dto", dto);
		}
		return view;
	}

}
