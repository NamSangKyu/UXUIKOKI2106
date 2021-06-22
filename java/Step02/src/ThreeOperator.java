import java.util.Scanner;

public class ThreeOperator {

	public static void main(String[] args) {
		// 숫자 입력
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("숫자하나 입력하세요 : ");
		num = sc.nextInt();
		String result = num % 2 == 1 ? "입력하신 숫자는 짝수 입니다." : "입력하신 숫자는 홀수 입니다.";
		System.out.println(result);
	}

}
