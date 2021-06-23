import java.util.Arrays;

public class Array2DEx {

	public static void main(String[] args) {
		int[][] arr = new int[4][5];
		
		//길이 출력
		System.out.println(arr.length);//4 - 행 개수
		System.out.println(arr[0].length);//5 - 각 행의 열 개수
		System.out.println(arr[1].length);//5
		System.out.println(arr[2].length);//5
		System.out.println(arr[3].length);//5
		
		//값 저장
		int num = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j = 0; j<arr[i].length;j++) {
				arr[i][j] = num;
				num++;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
//			for(int j = 0; j<arr[i].length;j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}





