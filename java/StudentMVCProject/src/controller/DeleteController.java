package controller;

import java.util.Scanner;

import service.StudentService;

public class DeleteController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 삭제 작업을 시작합니다.........");
		System.out.print("삭제할 학번 : ");
		String no = sc.nextLine();
		boolean result = StudentService.getInstance().deleteStudent(no);
		
		if(result)
			System.out.println("해당 학생정보 삭제에 성공했습니다.");
		else
			System.out.println("해당 학생정보 삭제에 실패했습니다.");
			
	}

}









