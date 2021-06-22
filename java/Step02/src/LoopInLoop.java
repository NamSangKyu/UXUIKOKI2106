
public class LoopInLoop {

	public static void main(String[] args) {
		/*
		 * 	반복문 --> 원하는 만큼 코드를 반복
		 *     반복문 안에 반복문을 넣어서 또 다른 처리 과정
		 *     반복문 중첩을 했을때에는 중첩된 반복문의 초기값을 셋팅
		 */
		int dan = 2, is=1;
		
		while(dan < 10) {
			System.out.println(dan + "단");
			is = 1;
			while(is < 10) {
				System.out.println(dan + " * " + is + " = " + dan *is);
				is++;
			}
			dan++;
		}
	}

}
