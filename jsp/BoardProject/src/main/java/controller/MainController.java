package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//전체 게시글 목록
		System.out.println("MainController");
		String order = request.getParameter("order");
		ArrayList<BoardDTO> list = BoardService.getInstance().selectAllBoard(order);
		request.setAttribute("list", list);
		return new ModelAndView("/board/board_list.jsp", false);
	}

}





