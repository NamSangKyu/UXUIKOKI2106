import java.util.Scanner;

public class ArrayQuest02 {
	/*
	 * 정수형 배열 5개짜리 선언
	 * 선언한 배열에 값을 Scanner를 이용해서 직접 입력
	 * 배열의 저장된 값들 중에 최대값,최소값을 출력
	 */
	public static void main(String[] args) {
		// 정수형 배열 5개짜리 선언
		int[] arr = new int[5];
		// 선언한 배열에 값을 Scanner를 이용해서 직접 입력
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + "번째 숫자 입력 : ");
			arr[i] = sc.nextInt();
		}
		//최대값 최소값
		int max,min;
		max = min = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max < arr[i])
				max = arr[i];
			if(min > arr[i])
				min = arr[i];
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}

}








