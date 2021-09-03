package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(id.equals("admin") && pass.equals("product")) {
			request.getSession().setAttribute("login", true);
			return new ModelAndView("productList.do", false);
		} else {
			response.getWriter().write("<script>alert('아이디와 비밀번호를 확인하세요');history.back();</script>");
			
		}
		
		return null;
	}

}
