package service;

import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardCommentDTO;
import dto.BoardDTO;

public class BoardService {
	private static BoardService instance = new BoardService();

	private BoardService() {
		super();
	}

	public static BoardService getInstance() {
		if(instance==null)
			instance = new BoardService();
		return instance;
	}

	public void InsertBoard(BoardDTO dto) {
		BoardDAO.getInstance().insertBoard(dto);
	}
	
	public ArrayList<BoardDTO> selectAllBoard(String order, int currentPageNo){
		return BoardDAO.getInstance().selectAllBoard(order, currentPageNo);
	}

	public BoardDTO selectBoard(int bno) {
		return BoardDAO.getInstance().selectBoard(bno);
	}

	public void addBoardCount(int bno) {
		BoardDAO.getInstance().addBoardCount(bno);		
	}

	public void deleteBoard(int bno) {
		BoardDAO.getInstance().deleteBoard(bno);		
	}

	public void updateBoard(int bno, String title, String content) throws Exception {
		BoardDAO.getInstance().updateBoard(bno, title, content);
	}

	public boolean insertBoardLike(int bno, String id) {
		int count = BoardDAO.getInstance().insertBoardLike(bno,id);
		if(count==0)
			BoardDAO.getInstance().deleteBoardLike(bno,id);
		return count == 1;
	}

	public boolean insertBoardHate(int bno, String id) {
		int count = BoardDAO.getInstance().insertBoardHate(bno,id);
		if(count==0)
			BoardDAO.getInstance().deleteBoardHate(bno,id);
		return count == 1;
	}

	public int selectBoardCount() {
		return BoardDAO.getInstance().selectBoardCount();
	}

	public int insertBoardComment(BoardCommentDTO dto) {
		return BoardDAO.getInstance().insertBoardComment(dto);
	}

	public ArrayList<BoardCommentDTO> selectAllComment(int bno) {
		return BoardDAO.getInstance().selectAllComment(bno);
	}
	
}



