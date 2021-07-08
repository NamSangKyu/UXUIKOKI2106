package service;
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
import java.util.ArrayList;
import java.util.Scanner;

import vo.LibraryVO;


public class LibraryService {
	private ArrayList<LibraryVO> list;

	public LibraryService() {
		list = new ArrayList<LibraryVO>();
	}
	// 확인용 전체출력
	public void LibraryAllEmployee() {
		if(list.isEmpty()) {
			System.out.println("등록된 도서가 없습니다.");
			return;
		}
		for(int i=0;i<list.size();i++)
			list.get(i).printLibraryInfo();
		}
	//2. 도서 정보를 한건을 등록하는 기능을 작성하시오.(10점)
	public void insertLibrary(Scanner sc) {
		//도서가 가지고 있는 정보는 제목, 저자, 출판사, 대출가능상태 
		System.out.println("도서 정보 등록을 시작하겠습니다!");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("저자 : ");
		String writer = sc.nextLine();
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		System.out.print("대출 가능 상태 : ");
		String loanable = sc.nextLine();
		
		list.add(new LibraryVO(title, writer, publisher, loanable));
	}
	
	//3. 도서 정보를 제목으로 검색하는 기능을 작성시오(10점)
	public void searchLibrary(Scanner sc) {
		System.out.println("도서 정보 검색을 시작합니다!");
		System.out.print("검색 할 제목을 입력하세요 : ");
		String no = sc.nextLine();
	
		if(list.isEmpty()) {
			System.out.println("검색한 도서가 없습니다.");
			return;
		}
		for(int i=0;i<list.size();i++)
			if(list.get(i).getTitle() == no)
				list.get(i).printLibraryInfo();
	}
	//4. 도서 대출을 실행하시오(10점)
	public void loanableLibrary() {
		
	}
	//5. 도서정보를 제목으로 검색하여 수정하시오 (10점)
	public void updateLibrary(Scanner sc) {
		System.out.println("도서 정보 수정을 시작합니다!");
		System.out.print("검색 할 제목을 입력하세요 : ");
		String no = sc.nextLine();
		LibraryVO vo = null;
		int r = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle() == no) {
				vo = list.get(i);
				r = i;
				break;
			}
		}	
				
	}
	
}
