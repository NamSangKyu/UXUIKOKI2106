
public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student("AB10001");
		System.out.println(s1.studentNo + " " + s1.name + " " + s1.major + " " + s1.score);
		
		Student s2 = new Student("AA2001", "김첤수", "게임학과", 3.6);
		s2.printStudentInfo();
		
	}

}
