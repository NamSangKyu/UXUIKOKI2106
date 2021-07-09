package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.StudentDAO;
import exception.StudentException;
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

	public int insertStudent(StudentVO studentVO) throws StudentException {
		StudentVO vo = selectSnoStudent(studentVO.getSno());
		if(vo != null)
			throw new StudentException("중복된 회원 내용이 있습니다.");
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

	public HashMap<String, Integer> selectMajorCount() {
		return dao.selectMajorCount();
	}

	public HashMap<Integer, ArrayList<StudentVO>> selectTop10Score() {
		return dao.selectRankTop10();
	}
	
}













