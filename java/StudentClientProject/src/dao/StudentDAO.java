package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import config.DBManager;

public class StudentDAO {
	private static StudentDAO instance = new StudentDAO();
	
	private Connection conn;
	
	private StudentDAO() {
		conn = DBManager.getInstance().getConn();
	}

	public static StudentDAO getInstance() {
		if(instance == null)
			instance = new StudentDAO();
		return instance;
	}
	
	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String> login(String sno) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select * from student where sno like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map.put("sno", rs.getString(1));
				map.put("name", rs.getString(2));
			}
			System.out.println(map.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt,rs);
		}	
		
		return map;
	}

	
}









