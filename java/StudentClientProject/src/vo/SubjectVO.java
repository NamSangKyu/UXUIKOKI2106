package vo;

public class SubjectVO {
	private String sno;
	private String name;
	private String profesorNo;
	private int count;
	public SubjectVO(String sno, String name, String profesorNo, int count) {
		super();
		this.sno = sno;
		this.name = name;
		this.profesorNo = profesorNo;
		this.count = count;
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
		System.out.printf("%s %s %s %d\n",sno,name,profesorNo,count);
	}
	
	
}





