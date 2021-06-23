import java.util.Scanner;

public class Quest2 {

	public static void main(String[] args) {
		/*
		 * 		숫자 하나 입력을 받아서
		 * 		step1 -> 입력한 숫자의 모든 약수를 출력
		 * 		step2 -> 입력한 숫자가 완전수 인지 판단하는 코드를 작성
		 * 		숫자 입력 : 6
		 * 		1 2 3 6
		 * 		입력하신 숫자는 완전수 입니다.		
		 * 
		 * 		완전수 : 약수들 중 자신을 제외한 약수들의 합이 자신의  숫자와 같은 경우
		 */
		Scanner sc = new Scanner(System.in);
		int num, total = 0;
		System.out.print("숫자 입력 : ");
		num = sc.nextInt();
		for(int i=1;i<num+1;i++) {
			if(num % i == 0) {
				total += i;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		total -= num;
		if(total == num)
			System.out.println("입력하신 숫자는 완전수 입니다.");
		else
			System.out.println("입력하신 숫자는 완전수가 아닙니다.");
	}

}









