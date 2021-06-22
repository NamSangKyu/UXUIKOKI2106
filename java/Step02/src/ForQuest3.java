import java.util.Scanner;

public class ForQuest3 {

	public static void main(String[] args) {
		// 숫자 하나 입력을 받으면 아래와 같이 출력
		// 숫자 입력 : 5
		// *
		// **
		// ***
		// ****
		// *****
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int n = sc.nextInt();
		String str = "";//빈문자열
		for(int i=0;i<n;i++) {
			str += "*";
			System.out.println(str);
		}
	}

}







