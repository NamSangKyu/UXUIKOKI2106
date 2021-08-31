package service;

import java.util.ArrayList;

import dao.BoardDAO;
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
	
	public ArrayList<BoardDTO> selectAllBoard(){
		return BoardDAO.getInstance().selectAllBoard();
	}

	public BoardDTO selectBoard(int bno) {
		return BoardDAO.getInstance().selectBoard(bno);
	}
	
}



