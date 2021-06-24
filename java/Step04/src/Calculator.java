
public class Calculator {
	int addCount;
	int subCount;
	int mulCount;
	int divCount;
	
	//정수 두개를 받아서 덧셈 결과를 정수로 되돌려주는 기능
	int sum(int n1, int n2) {
		addCount++;//실행한 메서드 횟수 증가
		return n1 + n2;
	}
	//정수 두개를 받아서 뺄셈 결과를 되돌려 주는 기능
	int sub(int n1, int n2) {
		subCount++;
		return n1-n2;
	}
	//정수 두개를 받아서 곱셈 결과를 되돌려 주는 기능
	int mul(int n1, int n2) {
		mulCount++;
		return n1 * n2;
	}
	//정수 두개를 받아서 나눗셈 결과를 되돌려 주는 기능 
	int div(int n1, int n2) {
		divCount++;
		return n1 / n2;
	}
	//각 메서드 호출한 개수들을 출력하는 메서드 작성
	void printCalcCount() {
		System.out.println("덧셈 횟수 : "+addCount);
		System.out.println("뺄셈횟수 : "+subCount);
		System.out.println("곱셈 횟수 : "+mulCount);
		System.out.println("나눗셈 횟수 : "+divCount);
	}
}








