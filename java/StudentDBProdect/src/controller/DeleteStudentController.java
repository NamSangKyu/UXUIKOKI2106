package controller;

import java.util.Scanner;

import service.StudentService;

public class DeleteStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보를 삭제합니다............");
		System.out.print("삭제할 학번 : ");
		String sno = sc.nextLine();
		
		int count = StudentService.getInstance().deleteStudent(sno);
		
		if(count == 0)
			System.out.println("삭제할 학생정보가 없습니다.");
		else
			System.out.println("학생 정보 삭제를 완료하였습니다.");
	}

}




