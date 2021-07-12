package service;
import java.util.HashMap;

import dao.StudentDAO;
import exception.StudentException;

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

	
}





