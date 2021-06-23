import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuest01 {

	public static void main(String[] args) {
		//정수형 배열 5개짜리 선언
		int[] arr = new int[5];
		//선언한 배열에 값을 Scanner를 이용해서 직접 입력
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.print(i+1+"번째 숫자 입력 : ");
			arr[i] = sc.nextInt();
		}
		
		//입력이 끝난 후에 배열의 내용을 전체 출력
		System.out.println(Arrays.toString(arr));
	}

}



