package main;
/*도서관 관리 프로그램을 구축할려고 한다.
도서가 가지고 있는 정보는 제목, 저자, 출판사, 대출가능상태 등을 가지고 있으며 아래 제시한 작업을 수행하는 클래스들을 작성하고 소스코드를 업로드 하시오
배열, ArrayList등 본인이 쓰고 싶은 걸로 쓰시오.

1. 도서 정보하나를 저장할 클래스를 작성하시오. (10점)
2. 도서 정보를 한건을 등록하는 기능을 작성하시오.(10점)
3. 도서 정보를 제목으로 검색하는 기능을 작성시오(10점)
4. 도서 대출을 실행하시오(10점)
5. 도서정보를 제목으로 검색하여 수정하시오 (10점)
6. 각 클래스가 정확하게 동작하겠끔 연결하여 작성하시오(10점)
*/
import java.util.Scanner;

import service.LibraryService;

public class LibraryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LibraryService service = new LibraryService();
		
		while(true) {
			System.out.println("----도서 관리 프로그램----");
			System.out.println("   1. 도서 정보 추가");
			System.out.println("   2. 도서 정보 전체 출력");
			System.out.println("   3. 도서 검색");
			System.out.println("   4. 도서 대출");
			System.out.println("   5. 도서 정보 수정");
			System.out.println("   0. 프로그램 종료");
			System.out.print("원하시는 메뉴 번호 입력 : ");
			int no = sc.nextInt();
			sc.nextLine();
			if(no==0) 
				break;
			else if(no == 1)
				service.insertLibrary(sc);
			else if(no == 2)
				service.LibraryAllEmployee();
			else if(no == 3)
				service.searchLibrary(sc);
			else if(no == 4)
				service.loanableLibrary();
			else
				service.updateLibrary(sc);
			
		}
	}

}
