import java.util.Scanner;

public class WhileQuest1 {

	public static void main(String[] args) {
		//숫자 하나를 입력 받아서
		//입력한 숫자의 개수만큼 Hello World 출력
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("숫자 하나 입력 : ");
		n = sc.nextInt();
		
		int i = 0;
		// 0 1 2 3 4 5 .....
		while(i < n) {
			System.out.println("Hello World "+i);
			i++;
		}
		
	}

}



