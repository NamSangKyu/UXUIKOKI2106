
public class StringTest {

	public static void main(String[] args) {
		String str1 = "Hello1";
		String str2 = "Hello2";
		
		System.out.println(str1);
		System.out.println(str2);
		//문자열로 덧셈 연산을 하면 하나의 문자열로 합침
		System.out.println(str1 + str2);
		int num = 20;
		System.out.println(str1 + num + str2);
		String str3 = "안녕"+10+20*30;
		System.out.println(str3);
	}

}
