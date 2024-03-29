package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

	public StudentVO selectSnoStudent(String sno) {
		String sql = "select s.sno, s.name, m.major_name, s.score from student s, major m"
				+ " where s.major_no = m.major_no and s.sno like ?";
		
		PreparedStatement pstmt = null;
		StudentVO vo = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new StudentVO(rs.getString(1), rs.getString(2), 
						-1, rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int updateStudent(StudentVO vo) {
		String sql = "update student set name = ?, major_no = ?, score = ? where sno like ?";
		int count = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getMajorNo());
			pstmt.setDouble(3, vo.getScore());
			pstmt.setString(4, vo.getSno());
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public int deleteStudent(String sno) {
		String sql = "delete from student where sno like ?";
		int count = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public HashMap<String, Integer> selectMajorCount() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select major_name, count(*) from student s , major m "
				+ "where s.major_no = m.major_no group by m.major_name";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return map;
	}
	
	public HashMap<Integer, ArrayList<StudentVO>> selectRankTop10(){
		HashMap<Integer, ArrayList<StudentVO>> map = new HashMap<Integer, ArrayList<StudentVO>>();
		
		String sql = "select * from rank_student_view where rk <= 10";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//해당 순위가 저장되어 있는 리스트 꺼냄
				ArrayList<StudentVO> list = map.get(rs.getInt(1));
				//null이면 맵에 해당 순위가 있는 리스트가 없음
				if(list == null)
					list = new ArrayList<StudentVO>();
				list.add(new StudentVO(rs.getString(2), rs.getString(3), -1,
						rs.getString(4), rs.getDouble(5)));
				map.put(rs.getInt(1), list);//순위 정보가 있는 리스트 최신화
			}
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
				
		
		
		return map;
	}

	public ArrayList<StudentVO> selectKickStudent() {
		String sql = "select * from "
				+ "(select * from rank_student_view order by rk desc) s "
				+ "where ROWNUM <= 5 and score < 2.0";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new StudentVO(rs.getString(2), rs.getString(3), -1,
						rs.getString(4), rs.getDouble(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}








