package staticex;

public class Number {
	private static int number = 0;
	private int count;
	public Number() {
		number++;
		count++;
	}
	
	public static int getNumber() {
		//static은 static으로 선언된 것만 접근이 가능
		//count++;
		return number;
	}
	
}
