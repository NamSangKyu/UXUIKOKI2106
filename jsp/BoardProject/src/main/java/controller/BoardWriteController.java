package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		 
		BoardDTO dto = new BoardDTO(title, content, writer);
		BoardService.getInstance().InsertBoard(dto);
		ArrayList<BoardDTO> list = BoardService.getInstance().selectAllBoard("bno");
		request.setAttribute("list", list);		
		return new ModelAndView("/board/board_list.jsp", false);
	}

}
