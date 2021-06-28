package fiinal_class;

public class SalesEmployee extends Employee{
	//부모클래스가 상속해준 메서드 중 final 키워드가 붙어있는 메서드는 재정의가 불가능하다. 
	public int getSalary() {
		return 0;
	}
}
