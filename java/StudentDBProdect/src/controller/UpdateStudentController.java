package controller;

import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class UpdateStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 수정을 시작합니다......");

		System.out.print("수정할 학번 : ");
		String sno = sc.nextLine();
		
		StudentVO vo = StudentService.getInstance().selectSnoStudent(sno);
		
		if(vo==null) {
			System.out.println("수정할 학생정보가 없습니다.");
			return;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학과번호 : ");
		int major = sc.nextInt();
		sc.nextLine();
		System.out.print("평점 : ");
		double score = sc.nextDouble();
		sc.nextLine();
		vo = new StudentVO(sno, name, major, null, score);
		int count = StudentService.getInstance().updateStudent(vo);
		if(count == 0)
			System.out.println("수정 작업에 실패하였습니다.");
		else
			System.out.println("수정 작업에 성공하였습니다.");
			
	}

}







