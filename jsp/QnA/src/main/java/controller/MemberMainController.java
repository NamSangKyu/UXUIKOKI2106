package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public class MemberMainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//사용자 질문 목록
		//질문 내용을 등록 뷰
		return new ModelAndView("/member/member_main.jsp", false);
	}

}
