package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDTO;
import dto.MemberDTO;
import service.BoardService;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MemberDTO dto = MemberService.getInstance().login(id, pass);
		
		if(dto != null) {
			//로그인 성공 했을때
			session.setAttribute("obj", dto);
			ArrayList<BoardDTO> list = BoardService.getInstance().selectAllBoard("bno",1);
			request.setAttribute("list", list);
			return new ModelAndView("/board/board_list.jsp", false);
		}else {
			out.print("<script>");
			out.print("alert('로그인 실패, 아이디 비번 확인하세요');");
			out.print("history.back();");
			out.print("</script>");
		}
		return null;
	}

}
