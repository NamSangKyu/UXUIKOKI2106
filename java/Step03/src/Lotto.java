import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[7];
		Random r = new Random();
		
		//반복문
		//  1. 숫자를 랜덤하게 뽑음 1~45
		//  2. 랜덤하게 뽑은 숫자가 배열에 저장되어 있는지 체크
		//		2-1. 배열에 해당 숫자가 저장되어 있지 않으면 저장
		//  	2-2. 배열에 해당 숫자가 있으면 다시 1번부터 수행 
		//	3. 배열을 출력
		for(int i=0;i<lotto.length;i++) {
			int num = r.nextInt(45)+1;
			boolean flag = true;
			for(int j=0;j<lotto.length;j++) {
				if(lotto[j] == num) {
					flag = false;
					break;
				}
			}
			if(flag)
				lotto[i] = num;
			else
				i--;
		}
		System.out.println(Arrays.toString(lotto));
	}

}





