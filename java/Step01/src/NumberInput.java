import java.util.Scanner;

public class NumberInput {

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("숫자하나 입력하세요.");
		//입력 처리
		num = sc.nextInt();
		System.out.println(num*2);
		
	}
}
