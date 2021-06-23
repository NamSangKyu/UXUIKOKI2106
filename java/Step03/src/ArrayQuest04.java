import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuest04 {

	public static void main(String[] args) {
		/*
		 * 정수형 10개 짜리 선언 후
		 * 숫자 10개를 입력을 받아서 배열에 저장을 할때
		 * 짝수면 맨위에서 부터 채움
		 * 홀수면 맨앞에서 부터 채움
		 * 
		 * 입력이 끝나면 배열에 모든 요소를 출력 
		 * 
		 * 1 2 3 4 5 6 7 8 9 10 <- 이 순서로 입력
		 * 
		 * 0 1 2 3 4 5  6 7 8 9
		 * 1 3 5 7 9 10 8 6 4 2    
		 */
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int start=0, end=arr.length-1;
		
		while(!(start > end)) {
			int num;
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
			if(num % 2 == 1) {
				arr[start] = num;
				start++;
			}else {
				arr[end] = num;
				end--;
			}			
		}
		System.out.println(Arrays.toString(arr));
		
	}

}









