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
	public void reallocArray() {
		StudentVO[] temp = arr;
		arr = new StudentVO[temp.length+5];
		for(int i=0;i<temp.length;i++)
			arr[i] = temp[i];
	}
	public boolean registerStudent(StudentVO vo) {
		if(index==arr.length)
			reallocArray();
		for(int i=0;i<index;i++) {
			//동일한 학번이있는지 검사
			if(arr[i].getStudentNo().equals(vo.getStudentNo()))
				return false;//학생정보를 등록 못한 경우 false
		}
		arr[index] = vo;//받아온 vo 배열에 저장
		index++;
		return true;//학생정보를 등록을 한 경우 true;
	}

	public void selectAllStudent() {
		System.out.println("전체 학생 정보를 출력합니다......");
		if(index == 0) {
			System.out.println("출력할 학생 데이터가 없습니다.");
			return;
		}
		for(int i=0;i<index;i++)
			arr[i].printStudentInfo();
	}

	
}




