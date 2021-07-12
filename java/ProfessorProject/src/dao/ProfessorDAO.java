package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import session.LoginSession;

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
	public ArrayList<String> selectRegisterSubjectList(String pno) {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select subject_name || ' - ' || scount || '명' "
				+ "from subject where profersor_no like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	public ArrayList<String> selectSubject(String subject) {
		//String sql = "select * from major where major_name like '%" + subject + "%'";
		String sql = "select * from subject where subject_name like '%'||?||'%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1) + " " + rs.getString(2) 
				+ " " + rs.getString(3) + " " + rs.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void insertSubject(String no, String name, int count) {
		String sql = "insert into subject values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);		
			pstmt.setString(2, name);		
			//로그인 되어있는 교수번호로 등록
			pstmt.setString(3, LoginSession.getInstance().getPno());		
			pstmt.setInt(4, count);
			
			int result = pstmt.executeUpdate();
			
			if(result == 0)
				System.out.println("과목 등록 실패");
			else {
				System.out.println("과목 등록 성공");
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateSubject(String sno, String name, int ea) {
		String sql = "update subject set subject_name = ?, scount = ?"
				+ " where profersor_no = ? and subject_no = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, ea);
			pstmt.setString(3, LoginSession.getInstance().getPno());
			pstmt.setString(4, sno);
			
			int count = pstmt.executeUpdate();
			if(count == 0 )
				System.out.println("업데이트 할 정보가 없습니다.");
			else
				System.out.println("업데이트 성공하였습니다.");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}











