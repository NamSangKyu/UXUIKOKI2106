package ex1;

public class ThrowsExample {
	public static void throwsTest() throws ArithmeticException, ArrayIndexOutOfBoundsException {
			System.out.println(5/0);
	}
	public static void main(String[] args) {
		try {
			throwsTest();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(1);
	}

}
