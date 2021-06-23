import java.util.Arrays;

public class Array2DQuest02 {

	public static void main(String[] args) {
		char[][] arr = new char[5][5];
		char ch = 'A';
		int sw = 1;
		int j=0;
		for(int i=0;i<arr.length;i++) {
			if(sw == 1)
				j=0;
			else
				j = arr.length-1;
			while(j < arr[i].length && j > -1) {
				arr[i][j] = ch;
				ch++;
				j += sw;
			}
			sw = -sw;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

}
