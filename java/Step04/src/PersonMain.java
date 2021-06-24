
public class PersonMain {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 20;
		p1.gender = '남';
		
		p1.printInfo();
//		System.out.println(p1.name + " " + p1.age + " " + p1.gender);
		
		Person p2 = new Person();
		p2.name = "김영희";
		p2.age = 24;
		p2.gender = '여';
		p2.printInfo();
//		System.out.println(p2.name + " " + p2.age + " " + p2.gender);
		
		Person p3 = new Person();
		p3.printInfo();
//		System.out.println(p3.name + " " + p3.age + " " + p3.gender);
		
		//생성자에 맞춰서 생성
		Person p4 = new Person("김철수");
		p4.printInfo();
//		System.out.println(p4.name + " " + p4.age + " " + p4.gender);
		
		Person p5 = new Person("김철수",33);
		p5.printInfo();
//		System.out.println(p5.name + " " + p5.age + " " + p5.gender);
		
		
		
	}

}



