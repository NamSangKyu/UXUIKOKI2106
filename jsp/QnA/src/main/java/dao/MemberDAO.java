package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DBManager manager;

	private MemberDAO() {
		super();
		manager = DBManager.getInstance();
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO login(String id, String pass) {
		String sql = "select * from member where id = ? and passwd = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString(3);
				int age = rs.getInt(4); 
				String gender = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				dto = new MemberDTO(id, pass, name, age, gender, point, grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
