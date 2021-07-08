package ex1;

public class CatchExample {

	public static void main(String[] args) {
		try {
			System.out.println(1);
			System.out.println(5/0);//나눈값 변경
			//인덱스 Exception도 발생
			System.out.println(2);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(3);
			System.out.println(e.getMessage());
		}catch (ArithmeticException e) {
			System.out.println(4);
			System.out.println(e.getMessage());
		}finally {
			System.out.println(5);
		}
		System.out.println(6);
	}

}
