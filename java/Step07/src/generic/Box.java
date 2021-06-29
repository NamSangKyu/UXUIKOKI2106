package generic;
/*
 * 제네릭은 필드나 메서드의 리턴 타입, 매개변수 타입을
 * 객체 생성 할때매다 유연하게 변수타입을 지정할 수 있는 문법
 */
public class Box<T> {
	private T data;

	public Box(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
