
public class Student {
	String studentNo;
	String name;
	String major;
	double score;
	
	//전체 필드 초기화하는 생성자 작성
	Student(String s, String n, String m, double c){
		studentNo = s;
		name = n;
		major = m;
		score = c;
	}
	
	Student(String studentNo){
		studentNo = studentNo;
	}
}
