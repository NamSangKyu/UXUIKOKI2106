package controller;

import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class SelectSnoStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("검색할 학번 입력 : ");
		String sno = sc.nextLine();
		
		StudentVO vo = StudentService.getInstance().selectSnoStudent(sno);
		
		if(vo == null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			vo.printStudentInfo();
		}
		
	}

}




