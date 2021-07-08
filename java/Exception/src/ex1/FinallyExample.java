package ex1;

public class FinallyExample {

	public static void main(String[] args) {
		try {
			System.out.println(1);
			System.out.println(5/1);
			System.out.println(2);
		}catch (Exception e) {
			System.out.println(3);
		}finally {
			System.out.println(4);
		}
		System.out.println(5);
	}

}
