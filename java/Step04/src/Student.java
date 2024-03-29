
public class Student {
	private String studentNo;
	private String name;
	private String major;
	private double score;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	// 전체 필드 초기화하는 생성자 작성
	public Student(String studentNo, String name, String major, double score) {
		this.studentNo = studentNo;
		this.name = name;
		this.major = major;
		this.score = score;
	}

	public Student(String studentNo, String name, String major) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.major = major;
	}

	public Student(String studentNo) {
		// this 키워드는 자기 자신 객체를 나타내닌 키워드
		// this.studentNo = studentNo;
		// 다른 생성자 호출
		this(studentNo, "이름", "전공", 0.0);
	}

	// 학생정보 출력하는 메서드
	// 학번 이름 학과 평점(등급)
	public void printStudentInfo() {
		System.out.println(studentNo + " " + name + " " + major + " " + score+"("+getGrade()+")");
	}
	//평점 등급을 구하는 메서드
	public String getGrade() {
		String grade = "F";
		if(score == 4.5)
			grade = "A+";
		else if(score >= 4.0)
			grade = "A";
		else if(score >= 3.5)
			grade = "B+";
		else if(score >= 3.0)
			grade = "B";
		else if(score >= 2.5)
			grade = "C+";
		else if(score >= 2.0)
			grade = "C";
		else if(score >= 1.5)
			grade = "D+";
		else if(score >= 1.0)
			grade = "D";
		
		return grade;
	}
}














