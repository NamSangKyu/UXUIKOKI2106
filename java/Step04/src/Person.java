
public class Person {
	String name;
	int age;
	char gender;
	
	//생성자 : 클래스를 생성할때 제일 먼저 실행되는 기능
	// 	기능명 : 클래스명
	Person(){
		System.out.println("기본 생성자");
		name = "이름값";
		age = 999;
		gender = '남';
	}
	//생성시 이름만 받아옴
	Person(String n){
		name = n;
		System.out.println("Person(String)");
	}
	//생성시 이름, 나이를 받아옴
	
}





