
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
}




