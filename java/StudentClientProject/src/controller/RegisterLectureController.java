package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.StudentService;
import vo.SubjectVO;

public class RegisterLectureController implements Controller {

	@Override
	public void excute(Scanner sc) {
		//수강 가능한 전체 과목 리스트를 조회
		ArrayList<SubjectVO> list = StudentService.getInstance().selectAllLecture();
		for(int i = 0;i < list.size();i++)
			list.get(i).printInfo();
		//과목번호 입력을 받고 실행
		
		

	}

}
