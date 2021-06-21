import java.util.Scanner;

public class Quest2 {
	/*
	 * 정수형으로 원의 반지름 하나 입력 받아서
	 * 반지름에 해당하는 원넓이와 원둘레를 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r;
		System.out.println("반지름 하나 입력하세요");
		r = sc.nextInt();
		double area = r*r*3.1415;
		System.out.println(area);
		double roundLength = 2*r*3.1415;
		System.out.println(roundLength);
	}

}
