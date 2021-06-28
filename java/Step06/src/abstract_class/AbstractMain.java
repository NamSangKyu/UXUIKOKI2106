package abstract_class;

public class AbstractMain {

	public static void main(String[] args) {
		Person p = new Person();
		Dog d = new Dog();
		p.eat();
		d.eat();
		//추상클래스는 직접적으로 생성이 불가
		//Animal animal = new Animal();
	}

}
