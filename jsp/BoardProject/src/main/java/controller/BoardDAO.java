package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DBManager;
import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private Connection conn; 
	private BoardDAO() {
		super();
		conn = DBManager.getInstance().getConnection();
	}

	public static BoardDAO getInstance() {
		if(instance==null)
			instance = new BoardDAO();
		return instance;
	}

	public void insertBoard(BoardDTO dto) {
		String sql = "insert into board(bno, title, content, writer, bdate, blike, bhate,bcount)"
				+ " value(board_no.seq, ?,?,?,sysdate,0,0,0)";
		//DB 처리
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			int count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
