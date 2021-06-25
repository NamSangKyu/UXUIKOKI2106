package singletone;

public class Counter {
	//자기 자신 타입의 static 변수
	private static Counter instance = new Counter();
	//private 생성자
	private Counter() {
		System.out.println("Counter Constructor");
	}
	//instance return 메서드
	public static Counter getInstance() {
		if(instance == null)
			instance = new Counter();
		return instance;
	} 
}
