package controller;

import java.util.Scanner;

import exception.StudentException;
import service.StudentService;
import vo.StudentVO;

public class InsertStudentController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 등록을 시작합니다......");
		//학생 정보 입력
		System.out.print("학번 : ");
		String sno = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학과번호 : ");
		int major = sc.nextInt();
		sc.nextLine();
		System.out.print("평점 : ");
		double score = sc.nextDouble();
		sc.nextLine();
		
		int result;
		try {
			result = StudentService.getInstance()
					.insertStudent(new StudentVO(sno, name, major, null, score));
			if(result == 1)
				System.out.println("학생정보 등록 성공");
			else
				System.out.println("학생정보 등록 실패");
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
			
	}

}





