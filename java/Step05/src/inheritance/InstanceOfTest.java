package inheritance;

public class InstanceOfTest {

	public static void main(String[] args) {
		Person p = new Person();
		Animal a = p;
		System.out.println(a instanceof Person);
		System.out.println(a instanceof Dog);
		System.out.println(p instanceof Animal);
		Dog d = (Dog)a;
		System.out.println("프로그램종료");
	}

}
