package dto;

import org.json.JSONObject;

public class BoardCommentDTO {
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String date;
	private int clike;
	private int chate;
	
	public BoardCommentDTO(int cno, int bno, String writer, String content, String date, int clike, int chate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.date = date;
		this.clike = clike;
		this.chate = chate;
	}

	public BoardCommentDTO() {
		super();
	}

	public BoardCommentDTO(int bno, String writer, String content) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getChate() {
		return chate;
	}

	public void setChate(int chate) {
		this.chate = chate;
	}

	@Override
	public String toString() {
		return "BoardCommentDTO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", content=" + content
				+ ", date=" + date + ", clike=" + clike + ", chate=" + chate + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		obj.put("bno", bno);
		obj.put("cno", cno);
		obj.put("writer", writer);
		obj.put("content", content);
		obj.put("date", date);
		obj.put("clike", clike);
		obj.put("chatte", chate);
		return obj;
	}
	
	
}
