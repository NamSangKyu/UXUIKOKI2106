import java.util.Arrays;

public class Array2DQuest01 {

	public static void main(String[] args) {
		char[][] arr = new char[5][5];
		char ch = 'A';
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = ch;
				ch++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
