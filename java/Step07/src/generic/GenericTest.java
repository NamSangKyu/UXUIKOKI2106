package generic;

import obj.Person;

public class GenericTest {

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<Integer>(10);
		Box<Double> box2 = new Box<Double>(3.1415);
		Box<Person> box3 = new Box<Person>(new Person("홍길동", 20));
		System.out.println();
	}

}
