package wrapper;

public class WrapperClass {

	public static void main(String[] args) {
		//변수 타입을 Wrapper클래스로 써도 된다.
		/*
		 *  Wrapper 클래스는 primitive 변수 타입을 Reference로 바꿀때 사용하는 클래스
		 *  Wrapper       primitive
		 * 	Integer <---- int
		 *  Double  <---- double
		 *  Float   <---- float
		 *  Boolean <---- boolean
		 *  Character <-- char
		 */
		int n1 = 10;
		//auto boxing
		Integer n2 = n1;
		//auto unboxing
		int n3 = n2;
		
		System.out.println(n1 * 2);
		System.out.println(n2 * 2);
		System.out.println(n3 * 2);
		//Wrapper 클래스 사용법
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(Integer.SIZE);
		String str = "123123";
		//문자열을 숫자로 변경
		System.out.println(Integer.parseInt(str)*2);
		str = "3.3245345";
		System.out.println(Double.parseDouble(str)*2);
		
		//1.5 이전 버전에서 boxing unboxing
		int n5 = 100;
		Object obj = n5;
		Integer n6 = (Integer)obj;
		Object val = n6;
		int n7 = (int) val;
	}

}





