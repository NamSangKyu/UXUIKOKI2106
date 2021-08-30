package dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String bdate;
	private int blike;
	private int bhate;
	private int bcount;
	public BoardDTO(int bno, String title, String content, String writer, String bdate, int blike, int bhate,
			int bcount) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.bdate = bdate;
		this.blike = blike;
		this.bhate = bhate;
		this.bcount = bcount;
	}
	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardDTO() {
		super();
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	public int getBhate() {
		return bhate;
	}
	public void setBhate(int bhate) {
		this.bhate = bhate;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", bdate="
				+ bdate + ", blike=" + blike + ", bhate=" + bhate + ", bcount=" + bcount + "]";
	}
	
	
	
}
