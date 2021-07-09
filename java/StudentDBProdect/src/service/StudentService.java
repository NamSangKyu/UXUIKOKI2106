package service;

import java.util.ArrayList;

import dao.StudentDAO;
import vo.StudentVO;

public class StudentService {
	private static StudentService instance = new StudentService();
	private StudentDAO dao;
	private StudentService() {
		dao = StudentDAO.getInstance();
	}

	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		return instance;
	}

	public int insertStudent(StudentVO studentVO) {
		return dao.insertStudentVO(studentVO);
	}
	
	public ArrayList<StudentVO> selectAllStudent(){
		return dao.selectAllStudent();
	}

	public StudentVO selectSnoStudent(String sno) {
		if(sno == null) return null;
		return dao.selectSnoStudent(sno);
	}

	public int updateStudent(StudentVO vo) {
		return dao.updateStudent(vo);
	}

	public int deleteStudent(String sno) {
		return dao.deleteStudent(sno);
	}
	
}













