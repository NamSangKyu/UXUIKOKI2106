package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("obj");
		boolean result = BoardService.getInstance().insertBoardLike(bno, dto.getId());
		String msg = result ? "좋아요 표시를 했습니다." : "좋아요를 취소했습니다.";
		response.getWriter().write(msg);
		response.getWriter().flush();
		return null;
	}

}
