package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				+ " values(board_no.nextval, ?,?,?,sysdate,0,0,0)";
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
	
	public ArrayList<BoardDTO> selectAllBoard(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String sql = "select * from board";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}










