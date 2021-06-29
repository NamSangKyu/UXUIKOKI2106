package service;

import java.util.ArrayList;
import java.util.Iterator;

import vo.StudentVO;

public class StudentService {
	//싱글톤 적용
	private static StudentService instance = new StudentService();

	private ArrayList<StudentVO> list;
	
	private StudentService() {
		list = new ArrayList<StudentVO>();
	}

	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		return instance;
	}
	//학생정보 등록하는 부분을 리스트에 맞게 변경
	public boolean registerStudent(StudentVO vo) {
		return list.add(vo);//학생정보를 등록을 한 경우 true;
	}
	//학생정보 전체 출력하는 부분을 리스트에 맞게 변경 - Iterator로 작업
	public void selectAllStudent() {
		System.out.println("전체 학생 정보를 출력합니다......");
		if(list.isEmpty()) {
			System.out.println("출력할 학생 데이터가 없습니다.");
			return;
		}
		Iterator<StudentVO> it = list.iterator();
		while(it.hasNext())
			it.next().printStudentInfo();
	}
	//학생정보 검색하는 부분을 작성
	public StudentVO searchStudent(String no) {
		for(int i=0;i<list.size();i++) {
			//동일한 학번이있는지 검사
			if(list.get(i).getStudentNo().equals(no))
				return list.get(i);//검색한 학생정보의 인덱스 번호를 리턴
		}
		return null;//검색한 결과가 없을 때
	}
	//학생 정보를 삭제
	public boolean deleteStudent(String no) {
		StudentVO vo = searchStudent(no);
		
		if(vo == null)
			return false;
		
		return list.remove(vo);
	}

	public void updateStudent(StudentVO vo, StudentVO newVo) {
		int i = list.indexOf(vo);//vo가 있는 인덱스 위치값 리턴
		list.set(i,newVo);//인덱스 i 위치에 있는 값을 교체
	}

	
}













