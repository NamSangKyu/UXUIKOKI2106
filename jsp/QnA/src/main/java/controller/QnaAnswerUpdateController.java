package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class QnaAnswerUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String awriter = request.getParameter("awriter");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String acontent = request.getParameter("acontent");
		String status = request.getParameter("status");
		QnaDTO dto = new QnaDTO();
		dto.setAcontent(acontent);
		dto.setAwriter(awriter);
		dto.setQno(qno);
		dto.setStatus(status);
		
		QnaService.getInstance().updateQna(dto);
		
		return new ModelAndView("adminMain.do", false);
	}

}
