package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public class AdminMainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//클라이언트 질문목록을 읽어오는 부분
		
		return new ModelAndView("/admin/admin_main.jsp", false);
	}

}
