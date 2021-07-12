package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.DBManager;
import oracle.jdbc.OracleTypes;
import vo.SubjectVO;

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

	public ArrayList<SubjectVO> selectLecture(String sno) {
		String sql = "call get_register_lecture(?, ?)";
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, sno);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				list.add(new SubjectVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(cstmt, rs);
		}
		return list;
		
	}

	public ArrayList<SubjectVO> selectAllLecture() {
		String sql = "Select * from subject";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new SubjectVO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt, rs);
		}
		
		return list;
	}

	public int registerLecture(String subjectNo, String sno) {
		String sql = "call REGISTER_SUBJECT_LECTURE(?,?,?)";
		CallableStatement cstmt = null;
		int result = 0;
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, subjectNo);
			cstmt.setString(2, sno);
			cstmt.registerOutParameter(3, OracleTypes.NUMBER);
			cstmt.execute();
			result = cstmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(cstmt,null);
		}
		
		
		
		return result;
	}

	
}









