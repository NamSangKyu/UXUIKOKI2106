package service;

import vo.StudentVO;

public class StudentService {
	//싱글톤 적용
	private static StudentService instance = new StudentService();

	private StudentVO[] arr;
	private int index;
	
	private StudentService() {
		arr = new StudentVO[10];
		index=0;
	}

	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		return instance;
	}

	
}
