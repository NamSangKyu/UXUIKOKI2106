package controller;

import java.util.Scanner;

import service.ProfessorService;
import session.LoginSession;

public class LoginController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("로그인을 작업을 시작합니다............");
		//교수번호, 이름
		System.out.print("교수번호 : ");
		String no = sc.nextLine();
		System.out.print("교수명 : ");
		String name = sc.nextLine();
		
		boolean flag = ProfessorService.getInstance().login(no, name);
		if(flag) {
			LoginSession.getInstance().login(no, name);
			System.out.println(name + " 교수님 로그인 하였습니다.");
		}else {
			System.out.println("로그인 실패, 교수번호 및 이름을 확인하세요");
		}
		
	}

}
