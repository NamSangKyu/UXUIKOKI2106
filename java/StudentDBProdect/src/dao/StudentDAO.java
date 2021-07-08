package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}





