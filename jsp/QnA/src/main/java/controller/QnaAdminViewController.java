package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDTO;
import dto.QnaDTO;
import service.QnaService;
import view.ModelAndView;

public class QnaAdminViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		QnaService.getInstance().updateStatus(qno,1);
		QnaDTO dto = QnaService.getInstance().selectQna(qno );
		request.setAttribute("dto", dto);
		ArrayList<FileDTO> list = QnaService.getInstance().selectFileList(qno);
		request.setAttribute("flist", list);
		return new ModelAndView("/admin/qna_admin_detail.jsp", false);
	}

}



