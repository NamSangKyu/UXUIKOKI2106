import java.util.Scanner;

public class Quest01 {
	/*
	 * 		숫자 두개를 입력을 받은 후
	 * 		두수의 최대 공약수를 출력
	 * 		
	 * 		숫자 입력 : 4
	 * 		숫자 입력 : 6
	 * 		두수의 최대 공약수 : 2 
	 */
	public static void main(String[] args) {
		int n1, n2;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		n1 = sc.nextInt();
		System.out.print("숫자 입력 : ");
		n2 = sc.nextInt();
		
		//방법1
		if(n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		int gcd = 1;
		for(int i=n1;i>1;i--) {
			if(n1 % i == 0 && n2 % i == 0) {
				gcd = i;
				break;
			}
		}
		System.out.println("두수의 최대 공약수 : " + gcd);
		
		
		//방법2
		while(n1 != 0) {
			if(n1 < n2) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			n1 -= n2;
		}
		System.out.println("두수의 최대 공약수 : " + n2);
	}

}








