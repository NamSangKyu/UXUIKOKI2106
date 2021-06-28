package controller;

import java.util.Scanner;

import service.StudentService;
import vo.StudentVO;

public class RegisterController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("학생정보 등록을 시작합니다........");
		//학생정보 하나 입력 받아서
		//StudentVO 생성
		System.out.print("학번 입력 : ");
		String no = sc.nextLine();
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("전공 입력 : ");
		String major = sc.nextLine();
		System.out.print("평점 입력 : ");
		double score = sc.nextDouble();
		
		boolean result = StudentService.getInstance().
				registerStudent(new StudentVO(no, name, major, score));
		if(result)
			System.out.println("학생정보 등록 성공");
		else
			System.out.println("학생정보 등록에 실패하였습니다.");
			
	}

}







