package main;
import java.util.Scanner;

import controller.Controller;
import controller.HandlerMapping;
import session.LoginSession;
public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----수강 신청 프로그램----");
			System.out.println("1. 로그인");
			if(LoginSession.getInstance().updateSession()) {
				System.out.println("2. 수강신청 목록 조회");
				System.out.println("3. 수강신청하기");
				System.out.println("4. 수강 취소하기");
				System.out.println("5. 수강 신청 가능한 목록 조회");
			}
			System.out.println("0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			sc.nextLine();//엔터를 메모리에서 비움
			if(no == 0) break;
			if(!LoginSession.getInstance().updateSession() && no > 1) {
				System.out.println("로그인 후 작업 수행해 주세요");
				continue;
			}
			
			Controller controller = HandlerMapping.getInstance().createController(no);
			if(controller != null)
				controller.excute(sc);
		}		
	}

}







