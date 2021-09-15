package org.korea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.korea.dto.MemberDTO;

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
		}finally {
			manager.close(pstmt, rs);
		}
		
		return dto;
	}
	public ArrayList<MemberDTO> selectAllMember(){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, rs);
		}
		
		return list;
	}

	public void deleteMember(String id) {
		String sql = "delete from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, null);
		}
	}

	public void updateMember(MemberDTO dto) {
		String sql = "update member set passwd = ?, name = ?, age = ?, grade = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(5, dto.getId());
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getGrade());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, null);
		}
	}

	public void insertMember(MemberDTO dto) {
		String sql = "insert into member(id,passwd,name,age)"
				+ " values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, null);
		}
		
	}

	public ArrayList<MemberDTO> searchMember(String search) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member where id like '%' || ? || '%' or "
				+ "name like '%' || ? || '%' or grade like '%' || ? || '%'";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, rs);
		}
		
		return list;
	}
}











