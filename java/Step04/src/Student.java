
public class Student {
	String studentNo;
	String name;
	String major;
	double score;
	
	//전체 필드 초기화하는 생성자 작성
	Student(String studentNo, String name, String major, double score){
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


	Student(String studentNo){
		//this 키워드는 자기 자신 객체를 나타내닌 키워드
		//this.studentNo = studentNo;
		//다른 생성자 호출
		this(studentNo, "이름","전공",0.0);
	}
}







