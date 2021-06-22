import java.util.Scanner;

public class ElseIfQuest {

	public static void main(String[] args) {
		/*
		 * 		나이를 입력 : 35
		 * 		
		 * 		영유아 무료 	7세까지
		 * 		학생 1500원	19세
		 * 		성인 2500원	69세
		 *		노인 2000원 	70세
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int age = 0;
		System.out.print("나이를 입력 : ");
		age = sc.nextInt();
		if(age < 8)
			System.out.println("영유아는 무료 입니다.");
		else if(age < 20)
			System.out.println("학생은 1500원 입니다.");
		else if(age < 70)
			System.out.println("성인은 2500원 입니다.");
		else
			System.out.println("노인은 2000원 입니다.");
	}

}








