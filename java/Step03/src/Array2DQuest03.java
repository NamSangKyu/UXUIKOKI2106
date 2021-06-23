import java.util.Arrays;

public class Array2DQuest03 {

	public static void main(String[] args) {
		int[][] arr1 = new int[][] {{1,2,3,4,5},{6,7,8,9,10}};
		int[][] arr2 = new int[5][2];
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr2[j][i] = arr1[i][j];
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		
	}

}
