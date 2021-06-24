import java.util.Arrays;

public class DalPang {

	public static void main(String[] args) {
		char[][] arr = new char[5][5];
		//count : 채우는 개수
		int count = 5;
		//i:행번호, j:열번호, add 증가값
		int i=0, j=-1, add=1;
		char ch = 'A';
		while(true) {
			//가로 방향 채우기
			//열번호 셋팅
			j+=add;
			for(int c=0;c<count;c++) {
				arr[i][j] = ch++; 
				j+=add;
			}
			j -= add;
			count--;
			//채울 개수가 없으면 멈춤
			if(count == 0) break;
			//세로 방향 채우기
			//행번호 셋팅
			i += add;
			for(int c=0;c<count;c++) {
				arr[i][j] = ch++;
				i+=add;
			}
			i-=add;
			add = -add;
		}
		for(int c=0;c<arr.length;c++) {
			System.out.println(Arrays.toString(arr[c]));
		}
	}

}





