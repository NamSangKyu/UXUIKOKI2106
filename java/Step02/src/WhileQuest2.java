import java.util.Scanner;

public class WhileQuest2 {

	public static void main(String[] args) {
		//숫자 두개를 입력 받은 후
		//첫번째 입력한 숫자부터 두번째 입력한 숫자까지 합을 출력
		//5 10을 입력시 --> 45
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		System.out.print("첫번째 숫자 입력 : ");
		n1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		n2 = sc.nextInt();
		int total = 0;
		while(n1 <= n2) {
			total += n1;
			n1++;
		}
		System.out.println("총합 : "+total);
		
	}

}


