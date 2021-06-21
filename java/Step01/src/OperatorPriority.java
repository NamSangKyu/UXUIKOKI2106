
public class OperatorPriority {

	public static void main(String[] args) {
		int n1 = 10 , n2 = 20;
		boolean result = ++n1 + 5 > 20 && n2-- * 2 > 30;
		System.out.println(result);
	}

}
/*
	()
	증감연산
	사칙연산
	비교연산
	논리연산
	대입/복합대입
*/