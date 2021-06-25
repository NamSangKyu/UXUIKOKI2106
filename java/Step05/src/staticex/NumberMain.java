package staticex;

public class NumberMain {

	public static void main(String[] args) {
		int n = Number.getNumber();
		System.out.println(n);
		Number n1 = new Number();
		Number n2 = new Number();
		Number n3 = new Number();
		System.out.println(n1.getNumber());
		System.out.println(n2.getNumber());
		System.out.println(n3.getNumber());
		System.out.println(Number.getNumber());
	}

}
