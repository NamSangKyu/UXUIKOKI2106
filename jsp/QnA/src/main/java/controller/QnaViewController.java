package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class QnaViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		QnaDTO dto = QnaService.getInstance().selectQna(qno );
		request.setAttribute("dto", dto);
		return new ModelAndView("/member/qna_detail.jsp", false);
	}

}
