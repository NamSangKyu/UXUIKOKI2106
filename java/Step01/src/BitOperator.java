
public class BitOperator {
	/*
	 * 	bit 연산자
	 * 		1. and : 둘다 1일때만 1이 되는 연산자  --> &
	 * 		2. or : 둘중에 하나라도 1이면 이되는 연산자  --> |
	 * 		3. not : 0 --> 1, 1 --> 0으로 뒤집는 연산자 --> ~
	 * 		4. xor : 서로 값이 달라야 1이되는 연산자 -->  ^  
	 * 		5. shift : <<  >>  --> 해당 방향으로 비트를 밀어내는 연산자
	 */
	public static void main(String[] args) {
		int n1 = 10;	  // 0000 0000 0000 0000 0000 0000 0000 1010
		int n2 = 8;		  // 0000 0000 0000 0000 0000 0000 0000 1000
		int and = n1 & n2;// 0000 0000 0000 0000 0000 0000 0000 1000
		System.out.println("and 연산 결과 : " + and);
		int or = n1 | n2; // 0000 0000 0000 0000 0000 0000 0000 1010
		System.out.println("or 연산 결과 : "+or);
		int xor = n1 ^ n2;// 0000 0000 0000 0000 0000 0000 0000 0010
		System.out.println("xor 연산 결과 : "+xor);
		int not = ~n1;    // 1111 1111 1111 1111 1111 1111 1111 0101
						  // 1000 0000 0000 0000 0000 0000 0000 1011
		System.out.println("not 연산 결과 : "+not);
		int n3 = 1;		  // 0000 0000 0000 0000 0000 0000 0000 0001
		n3 = n3 << 1;	  // 0000 0000 0000 0000 0000 0000 0000 0010 
		System.out.println(n3);
		n3 = n3 << 1;	  // 0000 0000 0000 0000 0000 0000 0000 0100
		System.out.println(n3);
		n3 = n3 << 1;     // 0000 0000 0000 0000 0000 0000 0000 1000
		System.out.println(n3);
		
		System.out.println(not >> 3);// >> 쉬프트연산은 부호비트 제외
		System.out.println(not >>> 3);// >>> 쉬프트연산은 부호비트 포함
	}

}



