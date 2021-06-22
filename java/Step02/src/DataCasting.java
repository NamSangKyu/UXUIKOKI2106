
public class DataCasting {

	public static void main(String[] args) {
		//자동 형변환
		int r = 3;
		//데이터 타입 메모리가 작은 타입이 큰 타입으로 변환
		//수의 체계상 개념이 더 큰것으로 변환 float와 int가 계산 int가 float로 변환
		System.out.println(r*r*3.1415f);
		//강제로 형변환
		double pi = 3.6415;
		int n = (int)pi;//소수점을 잘라냄
		System.out.println(n);
	}

}
