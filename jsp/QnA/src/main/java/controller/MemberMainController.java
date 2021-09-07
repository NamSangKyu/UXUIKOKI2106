package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class MemberMainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("dto");
		//사용자 질문 목록
		ArrayList<QnaDTO> list = QnaService.getInstance().selectQnaList(dto.getId());
		request.getSession().setAttribute("list", list);
		//질문 내용을 등록 뷰
		return new ModelAndView("/member/member_main.jsp", false);
	}

}







