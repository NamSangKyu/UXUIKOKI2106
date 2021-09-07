package dto;

public class QnaDTO {
	private int qno;
	private String qcode;
	private String qcontent;
	private String qdate;
	private String qwriter;
	private String status;//0 - 미확인, 1 - 읽음, 2 - 답변보류, 3 - 답변완료
	private String acontent;
	private String awriter;
	private String adate;
	public QnaDTO(int qno, String qcode, String qcontent, String qdate, String qwriter, String status, String acontent,
			String awriter, String adate) {
		super();
		this.qno = qno;
		this.qcode = qcode;
		this.qcontent = qcontent;
		this.qdate = qdate;
		this.qwriter = qwriter;
		this.status = status;
		this.acontent = acontent;
		this.awriter = awriter;
		this.adate = adate;
	}
	public QnaDTO() {
		super();
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQcode() {
		return qcode;
	}
	public void setQcode(String qcode) {
		this.qcode = qcode;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQdate() {
		return qdate;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	public String getQwriter() {
		return qwriter;
	}
	public void setQwriter(String qwriter) {
		this.qwriter = qwriter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAwriter() {
		return awriter;
	}
	public void setAwriter(String awriter) {
		this.awriter = awriter;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "QnaDTO [qno=" + qno + ", qcode=" + qcode + ", qcontent=" + qcontent + ", qdate=" + qdate + ", qwriter="
				+ qwriter + ", status=" + status + ", acontent=" + acontent + ", awriter=" + awriter + ", adate="
				+ adate + "]";
	}
	
}
