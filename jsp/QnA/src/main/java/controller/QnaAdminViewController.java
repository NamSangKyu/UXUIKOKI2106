package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class QnaAdminViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		QnaDTO dto = QnaService.getInstance().selectQna(qno );
		request.setAttribute("dto", dto);
		return new ModelAndView("/admin/qna_admin_detail.jsp", false);
	}

}
