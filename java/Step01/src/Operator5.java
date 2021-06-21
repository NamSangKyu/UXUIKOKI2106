
public class Operator5 {

	public static void main(String[] args) {
		int n = 10;
		//n이 5보다 크고 15다 작은지 체크하는 연산식을 작성
		//System.out.println(5 < n < 15);
		//논리 연산자 : &&  ||  !
		//	&&(AND 연산) : 양쪽의 결과같이 true일때만 true가 되는 연산자
		//       	      하나라도 false면 false가 되는 연산자
		//  ||(OR 연산)  : 둘중에 하나가 true면 true가 되는 연산자
		//	! (NOT 연산) : false -> true, true -> false 뒤집는 연산자
		//AND 연산
		System.out.println(n > 5 && n < 15);
		//OR 연산
		System.out.println(n > 10 || n < 17);
		//NOT 연산
		System.out.println(!(n > 5));
	}

}
