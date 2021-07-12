package controller;

import java.util.HashMap;
import java.util.Scanner;

import exception.StudentException;
import service.StudentService;
import session.LoginSession;

public class LoginController implements Controller {

	@Override
	public void excute(Scanner sc) {
		System.out.println("수정 관리 시스템에 로그인을 시작합니다.....");
		System.out.print("학번 : ");
		String sno = sc.nextLine();
		
		HashMap<String, String> map = null;
		try {
			map = StudentService.getInstance().login(sno);
			//로그인 정보 등록
			LoginSession.getInstance().login(map.get("sno"), map.get("name"));
			System.out.println("로그인 완료");
		} catch (StudentException e) {
			e.printStackTrace();
		}
		
		
	}

}




