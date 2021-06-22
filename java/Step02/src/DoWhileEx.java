
public class DoWhileEx {

	public static void main(String[] args) {
		int i = 10;
		/*
		 * do-while문은 반복할 일을 먼저 수행하고 조건을 비교
		 * 처음조건이 거짓이더라도 한번은 실행을 한다.
		 */
		do {
			System.out.println("Hello World");
			i++;
		}while(i<5);
	}

}
