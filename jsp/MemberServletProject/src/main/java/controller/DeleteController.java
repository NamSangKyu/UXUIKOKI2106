package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class DeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemberService.getInstance().deleteMember(id);
		ArrayList<MemberDTO> list = MemberService.getInstance().selectAllMember();
		request.getSession().setAttribute("list", list);
		return new ModelAndView("main.jsp", true);
	}

}






