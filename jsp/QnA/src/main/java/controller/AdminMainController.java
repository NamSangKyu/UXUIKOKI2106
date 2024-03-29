package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class AdminMainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//사용자 질문 목록
		ArrayList<QnaDTO> list = QnaService.getInstance().selectQnaAllList();
		request.getSession().setAttribute("list", list);
		return new ModelAndView("/admin/admin_main.jsp", false);
	}

}





