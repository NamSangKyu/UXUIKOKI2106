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
		 manager = DBManager.getInstance();
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	public MemberDTO login(String id, String pass) {
		MemberDTO dto = null;
		
		try {
			String sql = "select * from member where id = ? and passwd = ?";
			PreparedStatement pstmt = manager.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(3);
				int  age = rs.getInt(4);
				int gender= rs.getInt(5);
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



