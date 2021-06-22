import java.util.Scanner;

public class SwitchQuest {

	public static void main(String[] args) {
		// 평점을 입력 받으면 해당 평점에 해당하는 등급을 출력
		/*
		 * 평점 입력 : 4.2 
		 * 4.5 A+ 
		 * 4.0 ~ 4.4 A 
		 * 3.5 ~ 3.9 B+ 
		 * 3.0 ~ 3.4 B 
		 * 2.5 ~ 2.9 C+ 
		 * 2.0 ~ 2.4 C 
		 * 1.5 ~ 1.9 D+ 
		 * 1.0 ~ 1.4 D 
		 * 0.0 ~ 0.9 F
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("평점 입력 : ");
		double score = sc.nextDouble();

		//switch로 변경
		switch ((int) (score / 0.5)) {
		case 9:
			System.out.println("A+");
			break;
		case 8:
			System.out.println("A");
			break;
		case 7:
			System.out.println("B+");
			break;
		case 6:
			System.out.println("B");
			break;
		case 5:
			System.out.println("C+");
			break;
		case 4:
			System.out.println("C");
			break;
		case 3:
			System.out.println("D+");
			break;
		case 2:
			System.out.println("D");
			break;
		default:
			System.out.println("F");

		}

	}

}
