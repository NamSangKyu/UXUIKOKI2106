package controller;

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
	
}