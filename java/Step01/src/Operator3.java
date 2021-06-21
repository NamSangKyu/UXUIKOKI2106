
public class Operator3 {
	//증감 연산자 : ++ --
	//	변수에있는 숫자를 1씩 증가 시키거나 감소시키는 연산자
	//	= 없이 유일하게 값을 바꿀수 있는 연산자
	public static void main(String[] args) {
		int n1 = 10;
		n1++;
		System.out.println(n1);
		++n1;
		System.out.println(n1);
		n1--;
		System.out.println(n1);
		--n1;
		System.out.println(n1);
		System.out.println("---------");
		int n2 = 10;
		System.out.println(n2);//10
		System.out.println(n2++);//10 --> 후위형 : 먼저 연산을 하고 그 후에 증가
		System.out.println(n2);//11
		
		int n3 = 10;
		System.out.println(n3);//10
		System.out.println(++n3);//11 전위형 : 먼저 증가를 하고 그 후에 연산
		System.out.println(n3);//11
		
	}

}








