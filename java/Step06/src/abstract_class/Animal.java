package abstract_class;
//추상 클래스 : 직접적으로 생성이 안되는 클래스
//           추상메서드 때문에 추상화 처리가 되어있음
// 추상 클래스여야 추상메서드를 선언 할수가 있음
public abstract class Animal {
	
	public Animal() {
		System.out.println("Animal Constructor");
	}

	public abstract void eat();
	
}
