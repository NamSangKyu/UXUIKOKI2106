import java.util.Scanner;

public class OperatortQuest1 {

	public static void main(String[] args) {
		//숫자 두개 입력을 받은 후 입력 받은 숫자의 각각 사칙연산 결과를 출력
		//본인 폴더에 업로드
		Scanner sc = new Scanner(System.in);
		
		int n1, n2;
		System.out.println("숫자 하나 입력");
		n1 = sc.nextInt();
		System.out.println("숫자 하나 입력");
		n2 = sc.nextInt();
		
		System.out.println(n1 + n2);
		System.out.println(n1 - n2);
		System.out.println(n1 * n2);
		System.out.println(n1 / n2);
		System.out.println(n1 % n2);
		
	}

}



