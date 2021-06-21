
public class DoubleVariable {

	public static void main(String[] args) {
		//double과 float는 소수점이 있는 숫자 즉 실수를 저장하는 변수 타입
		double d1 = 3.1415;//실수 맨끝에 f가 안붙으면 double 타입이다. 
		System.out.println(d1*2);
		System.out.println(d1+2.324);
		System.out.println(d1-1.3456);
		
		float f1 = 3.1415f;//숫자 뒤에 f가 붙으면 해당 숫자는 float 타입이다.
		System.out.println(f1 * 2);
		System.out.println(f1 + 2.324);
		System.out.println(f1 - 1.3456);
	}

}
