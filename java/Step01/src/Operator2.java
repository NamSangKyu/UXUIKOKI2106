import java.util.Scanner;

public class Operator2 {

	public static void main(String[] args) {
		//숫자 하나 입력 받은 후에
		//해당 숫자에 10을 더해서 저장한 후 출력
		//복합 대입 연산자 : +=  -=  *=  /=  %=
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("숫자 입력");
		n = sc.nextInt();
		n += 10;//n = n + 10;
		System.out.println(n);
		n -= 7;
		System.out.println(n);
		n *= 2;
		System.out.println(n);
		n /= 5;
		System.out.println(n);
		n %= 3;
		System.out.println(n);
		
	}

}


