package main;

import java.util.Scanner;

import service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		//1. 서비스 클래스 생성
		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		//2. 반복
		while(true) {
			//	2-1. 메뉴출력
			System.out.println("----사원관리 프로그램----");
			System.out.println("   1. 사원 정보 추가");
			System.out.println("   2. 사원 정보 전체 출력");
			System.out.println("   3. 사원 정보 삭제");
			System.out.println("   4. 사원 정보 중 연봉 3000이상 출력");
			System.out.println("   0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호 입력 : ");
			//	2-2. 메뉴 번호 받음
			int no = sc.nextInt();
			sc.nextLine();
			//	2-3. 입력한 메뉴 번호에 따라 서비스 클래스에 있는 메서드 실행
			if(no==0) 
				break;
			else if(no == 1)
				service.insertEmployee(sc);
			else if(no == 2)
				service.selectAllEmployee();
			else if(no == 3)
				service.deleteEmployee(sc);
			else
				service.filterSalary();
			
		}
	}

}







