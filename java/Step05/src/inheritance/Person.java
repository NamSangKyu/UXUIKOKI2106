package inheritance;

public class Person extends Animal{

	public Person() {
		System.out.println("Person Constructor");
	}

	@Override
	public void eat() {
		super.eat(); 
		System.out.println("사람은 술을 먹습니다.");
	}
}
