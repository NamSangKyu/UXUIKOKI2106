package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBManager;

public class ProfessorDAO {
	private static ProfessorDAO instance = new ProfessorDAO();
	private Connection conn;
	private ProfessorDAO() {
		conn = DBManager.getInstance().getConn();
	}
	public static ProfessorDAO getInstance() {
		if(instance == null)
			instance = new ProfessorDAO();
		return instance;
	}
	public boolean login(String no, String name) {
		String sql = "select * from profersor "
				+ "where profersor_no like ? and profersor_name like ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}











