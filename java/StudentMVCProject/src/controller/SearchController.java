package controller;

import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class SearchController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 검색을 시작합니다........");
		System.out.println("검색할 학번을 입력하세요 : ");
		String no = sc.nextLine();
		int index = StudentService.getInstance().searchStudent(no);
		if(index == -1)
			System.out.println("검색한 결과가 없습니다.");
		else
			StudentService.getInstance().getStudentVO(index).printStudentInfo();
			
		
	}

}
