import java.util.Scanner;

public class ArrayQuest03 {

	public static void main(String[] args) {
		/*
		 * 정수형 배열 10개짜리 선언
		 * 선언한 배열에 값을 Scanner를 이용해서 직접 입력
		 * 배열의 저장된 값들 중에 짝수 개수를 출력
		 */
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + "번째 숫자 입력 : ");
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0)
				count++;
		}
		System.out.println("짝수 개수 : "+ count);
	}

}







