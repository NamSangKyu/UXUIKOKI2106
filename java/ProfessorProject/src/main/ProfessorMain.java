package main;
import java.util.Scanner;

import controller.Controller;
import controller.HandlerMapping;
public class ProfessorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("----학적관리 프로그램----");
			System.out.println("1. 학생정보 등록");
			System.out.println("2. 학생정보 검색");
			System.out.println("3. 학생정보 수정");
			System.out.println("4. 학생정보 삭제");
			System.out.println("5. 전체 학생정보 출력");
			System.out.println("6. 학과별 인원수 출력");
			System.out.println("7. 성적 상위 10명 출력");
			System.out.println("8. 제적 대상자 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			sc.nextLine();//엔터를 메모리에서 비움
			if(no == 0) break;
			
			Controller controller = HandlerMapping.getInstance().createController(no);
			if(controller != null)
				controller.excute(sc);
			
		}		
	}

}







