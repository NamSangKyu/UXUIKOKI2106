package vo;

//학번 이름 학과번호 학과명 평점
public class StudentVO {
	private String sno;
	private String name;
	private int majorNo;
	private String majorName;
	private double score;

	public StudentVO(String sno, String name, int majorNo, String majorName, double score) {
		super();
		this.sno = sno;
		this.name = name;
		this.majorNo = majorNo;
		this.majorName = majorName;
		this.score = score;
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

	public int getMajorNo() {
		return majorNo;
	}

	public void setMajorNo(int majorNo) {
		this.majorNo = majorNo;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", name=" + name + ", majorNo=" + majorNo + ", majorName=" + majorName
				+ ", score=" + score + "]";
	}

	public void printStudentInfo() {
		System.out.printf("%s %s %s %.2f\n", sno, name, majorName, score);
	}

}








