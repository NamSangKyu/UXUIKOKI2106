package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardUpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 사용자가 보낸 게시글 번호 읽어옴
		int bno = Integer.parseInt(request.getParameter("bno"));
		// 해당 번호에 해당하는 게시글을 조회
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		// 해당 게시글 정보를 저장
		request.setAttribute("board", dto);
		System.out.println(dto.toString());
		// 페이지 이동
		return new ModelAndView("/board/board_update_view.jsp", false);
	}

}
