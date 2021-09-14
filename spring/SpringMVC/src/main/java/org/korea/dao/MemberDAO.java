package org.korea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.korea.DIContainer;
import org.korea.MainController;
import org.korea.dto.MemberDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DBManager;

public class MemberDAO {
	private DBManager manager;

	public MemberDAO(DBManager manager) {
		this.manager = manager;
	}

	public MemberDTO login(String id, String pass) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member where id = ? and passwd = ?";
		MemberDTO dto = null;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setGrade(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

}












