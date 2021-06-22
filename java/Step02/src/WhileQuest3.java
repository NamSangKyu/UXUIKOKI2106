import java.util.Scanner;

public class WhileQuest3 {

	public static void main(String[] args) {
		//숫자 5개를 입력 받아서
		//입력한 숫자들의 평균을 출력
		//단 평균 결과는 소수점도 출력이 되어야 함
		int n, i=0;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		while(i<5) {
			System.out.print("숫자 입력 : ");
			n = sc.nextInt();
			total += n;
			i++;
		}
		System.out.println((double)total / 5);
	}

}






