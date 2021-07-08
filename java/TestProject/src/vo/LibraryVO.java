package vo;
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
public class LibraryVO {
	private String title;
	private String writer;
	private String publisher;
	private String loanable;
	
	public LibraryVO(String title, String writer, String publisher, String loanable) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.loanable = loanable;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLoanable() {
		return loanable;
	}
	public void setLoanable(String loanable) {
		this.loanable = loanable;
	}

	public void printLibraryInfo() {
		System.out.println(title + " " + writer + " " + publisher + " " + loanable);
	}
}
