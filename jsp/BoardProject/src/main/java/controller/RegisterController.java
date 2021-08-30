package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		System.out.println(name);
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		int result = MemberService.getInstance().insertMember(
				new MemberDTO(id,pass,name,age,gender,0,null));
		ModelAndView view = null;
		if(result == 1){
			//index.jsp로 이동
			view = new ModelAndView("index.jsp", true);
		}else{
			//뒤로가기
			response.getWriter().write("<script>alert(\"회원가입에 실패하였습니다.\");history.back();</script>");	
		}
		return view;
	}

}