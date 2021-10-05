package inner;

import inner.InnerClass.InClass;
import inner.InnerClass.InStaticClass;

public class InClassMain {

	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		//innerClass 객체 안에 있는 InClass 선언
		InClass inClass= innerClass.new InClass();
		inClass.printInNum();
		
		InnerClass in1 = new InnerClass();
		in1.setInNum(100);
		InClass ic1 = in1.new InClass();
		ic1.printInNum();
		
		//static으로 선언된 inner 클래스는 바로 생성 가능
		InnerClass.InStaticClass inStaticClass = new InStaticClass();
		inStaticClass.printInNum();
		
		
	}

}
