import java.util.Scanner;

public class BooleanTest {

	public static void main(String[] args) {
		boolean flag = false;
		System.out.println(flag);
		flag = true;
		System.out.println(flag);
		System.out.println(!flag);
		
		//숫자하나 입력을 받아서 해당 숫자가 짝수면 true, 홀수면 false 출력이 되게끔
		//flag 안에 연산 결과를 저장 후 출력
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("숫자 하나 입력하세요");
		n = sc.nextInt();
		flag = n % 2 == 0;
		System.out.println(flag);
	}

}
