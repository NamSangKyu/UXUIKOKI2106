package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.ProfessorService;
import session.LoginSession;

public class UpdateSubjectController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("등록한 강의 과목 정보 수정을 시작합니다......");
		
		ArrayList<String> list = ProfessorService.getInstance()
				.selectRegisterSubjectList(LoginSession.getInstance().getPno());
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		System.out.println();
		
		System.out.print("수정할 과목번호 : ");
		String sno = sc.nextLine();
		System.out.print("수정할 과목명 : ");
		String name = sc.nextLine();
		System.out.print("수정할 인원수 : ");
		int ea = sc.nextInt();
		
		ProfessorService.getInstance().updateSubject(sno,name,ea);
	}

}
