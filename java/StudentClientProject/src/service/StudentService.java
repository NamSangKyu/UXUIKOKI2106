package service;
import java.util.ArrayList;
import java.util.HashMap;

import dao.StudentDAO;
import exception.StudentException;
import vo.SubjectVO;

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

	public HashMap<String, String> login(String sno) throws StudentException {
		HashMap<String, String> map = dao.login(sno);
		if(map.size() == 0)
			throw new StudentException("학번을 확인하세요, 로그인 실패!");
		return map;
	}

	public ArrayList<SubjectVO> selectLecture(String sno) throws StudentException {
		ArrayList<SubjectVO> list = dao.selectLecture(sno);
		if(list.size() == 0)
			throw new StudentException("수강신청한 강의 목록이 없습니다.");
		return list;
	}

	public ArrayList<SubjectVO> selectAllLecture() {
		return dao.selectAllLecture();
	}

	
}





