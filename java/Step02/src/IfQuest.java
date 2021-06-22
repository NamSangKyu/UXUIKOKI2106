
public class IfQuest {

	public static void main(String[] args) {
		//숫자 1~100까지의 숫자 중 3과 7의 배수를 출력
		//단 3과 7의 공배수는 한번만 출력
		for(int i=1;i<101;i++) {
			if(i % 3 == 0 || i % 7 == 0)
				System.out.println(i);
		}
		
		//----------------------------------
		//숫자 1~100까지의 숫자 중 3과 7의 배수의 개수를 출력
		int count = 0;
		for(int i=1;i<101;i++) {
			if(i % 3 == 0 || i % 7 == 0)
				count++;
		}
		System.out.println("3과 7의 배수 개수 : " + count);
	}

}
