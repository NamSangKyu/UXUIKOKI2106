package service;

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
	
	
}













