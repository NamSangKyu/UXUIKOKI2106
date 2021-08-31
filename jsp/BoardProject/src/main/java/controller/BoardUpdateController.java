package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import view.ModelAndView;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		ModelAndView view = null;
		try {
			BoardService.getInstance().updateBoard(bno,title,content);
			view = new ModelAndView("boardList.do", false);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("<script>alert('"+e.getMessage()+"');history.back();</script>");
		}
		
		return view;
	}

}
