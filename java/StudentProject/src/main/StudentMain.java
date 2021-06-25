package main;
import java.util.*;

import service.StudentService;
public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		while(true) {
			System.out.println("----학적관리 프로그램----");
			System.out.println("1. 학생정보 등록");
			System.out.println("2. 학생정보 검색");
			System.out.println("3. 학생정보 수정");
			System.out.println("4. 학생정보 삭제");
			System.out.println("5. 전체 학생정보 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			sc.nextLine();//엔터를 메모리에서 비움
			if(no == 0) break;
			
			switch(no) {
			case 1:
				service.insertStudent(sc);
				break;
			case 2:
				service.selectStudent(sc);
				break;
			case 3:
				service.updateStudent(sc);
				break;
			case 4:
				service.deleteStudent(sc);
				break;
			case 5:
				service.selectAllStudent();
				break;
			}
			
			
		}		
	}

}







