package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import vo.StudentVO;
/*
 * DAO 클래스는 Service 클래스로부터 데이터를 받아서
 * DB에 데이터를 조작, 조회, 결과를 Service클래스로 리턴
 *  
 */
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
	
	//1. 학생정보 등록
	public int insertStudentVO(StudentVO vo) {
		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSno());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getMajorNo());
			pstmt.setDouble(4, vo.getScore());
			
			int count= pstmt.executeUpdate();
			System.out.println(count + "건 적용 완료");
			conn.commit();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//2. 학생정보 검색
	//3. 학생정보 수정
	//4. 학생정보 삭제
	//5. 전체 학생정보 출력
	public ArrayList<StudentVO> selectAllStudent() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		String sql = "select s.sno, s.name, m.major_name, s.score from student s, major m"
				+ " where s.major_no = m.major_no";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new StudentVO(rs.getString(1), rs.getString(2), 
						-1, rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}








