package abstract_class;

public class Person extends Animal {
	
	public Person() {
		System.out.println("Person Constructor");
	}

	@Override
	public void eat() {
		System.out.println("사람이 밥을 먹습니다.");
	}
}
