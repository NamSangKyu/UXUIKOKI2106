package vo;

public class SubjectVO {
	private int rno;
	private String sno;
	private String name;
	private String profesorNo;
	private int count;
	
	public SubjectVO(int rno, String sno, String name, String profesorNo, int count) {
		super();
		this.rno = rno;
		this.sno = sno;
		this.name = name;
		this.profesorNo = profesorNo;
		this.count = count;
	}
	public SubjectVO(String sno, String name, String profesorNo, int count) {
		super();
		this.sno = sno;
		this.name = name;
		this.profesorNo = profesorNo;
		this.count = count;
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfesorNo() {
		return profesorNo;
	}
	public void setProfesorNo(String profesorNo) {
		this.profesorNo = profesorNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void printInfo() {
		System.out.printf("%d %s %s %s %d\n",rno,sno,name,profesorNo,count);
	}
	
	
}





