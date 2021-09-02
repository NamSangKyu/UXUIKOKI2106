package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;
import vo.PaggingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//전체 게시글 목록
		System.out.println("MainController");
		//현재 페이지 번호 - Parameter로 받음 단, 페이지 번호가 없으면 1로 설정
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null ? 1 : Integer.parseInt(pageNo);
		
		//페이지 번호에 대한 게시글 목록을 조회
		String order = request.getParameter("order");
		ArrayList<BoardDTO> list = BoardService.getInstance().selectAllBoard(order,currentPageNo);
		request.setAttribute("list", list);
		//페이지 번호, 전체 게시글 개수를 PaggingVO 셋팅
		//전체 게시글 개수 - DB 조회
		int count = BoardService.getInstance().selectBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 4);
		request.setAttribute("pagging", vo);
		
		return new ModelAndView("/board/board_list.jsp", false);
	}

}





