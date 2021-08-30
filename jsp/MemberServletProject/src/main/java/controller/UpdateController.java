package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		int point = Integer.parseInt(request.getParameter("point"));
		String grade = request.getParameter("grade");
		
		int count = MemberService.getInstance().updateMember(new MemberDTO(id,null,name,age,gender,point,grade));
		ModelAndView view = null;
		if(count == 1){
			view = new ModelAndView("main.jsp", true);
		}else{
			response.getWriter().write("<script>history.back();</script>");
		}
		return view;
	}

}
