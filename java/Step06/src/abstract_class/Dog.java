package abstract_class;

public class Dog extends Animal{
	
	public Dog() {
		System.out.println("Dog Constructor");
	}

	@Override
	public void eat() {
		System.out.println("개가 사료를 먹습니다.");
	}
}
