
public class Quest03 {

	public static void main(String[] args) {
		/*
		 * 	1~100까지의 숫자들 중
		 *  소수만 출력
		 *  
		 *  ※소수는 1과 자기자신으로만 나누어지는 숫자
		 */
		for(int i=1;i<=100;i++) {
			int j;//나누는 숫자 2~자기자신 전까지
			for(j=2;j<i;j++) {
				if(i%j==0)
					break;					
			}
			if(i == j) System.out.print(i + " ");
		}
	}

}
