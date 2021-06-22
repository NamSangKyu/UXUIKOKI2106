import java.util.Scanner;

public class LoopInLoopQuest2 {

	public static void main(String[] args) {
		/*
		 * 숫자 하나 입력을 받으면 아래와 같이 출력
		 * 숫자 입력 : 5
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 > ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String str = "";
			// 공백 처리
			for (int j = 0; j < n - i - 1; j++) {
				str += " ";
			}
			//별 처리
			for(int j=0;j<=i;j++)
				str += "*";
			System.out.println(str);
		}
		//----------------------------
		for(int i=0;i<n-1;i++) {
			String str = "";
			//공백 처리
			for(int j=0;j<=i;j++)
				str += " ";
			
			for (int j = 0; j < n - i - 1; j++) 
				str += "*";
			
			System.out.println(str);
		}
		
	}

}








