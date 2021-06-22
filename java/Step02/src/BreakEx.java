
public class BreakEx {

	public static void main(String[] args) {
		int i=1, total = 0;
		
		//무한 루프
		while(true) {
			total += i;
			i++;
			if(total > 5000)
				break;//if 와 같이 쓰임, 감싸고 있는 반복문 종료
		}
		System.out.println(total);
	}

}
