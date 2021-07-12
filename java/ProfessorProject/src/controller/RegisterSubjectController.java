package controller;

import java.util.Scanner;

import service.ProfessorService;

public class RegisterSubjectController implements Controller {

	@Override
	public void excute(Scanner sc) {
		//과목번호, 과목명, 정원
		System.out.println("과목 등록을 시작합니다..........");
		System.out.print("과목 번호 입력하세요 : ");
		String no = sc.nextLine();
		System.out.print("과목명 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("수강 정원을 입력하세요 : ");
		int count = sc.nextInt();
		sc.nextLine();
		ProfessorService.getInstance().insertSubject(no,name,count);
		
	}

}







