package list;

import java.util.ArrayList;

import obj.Person;

public class PersonListTest {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", 20));
		list.add(new Person("김철수", 30));
		list.add(new Person("박영수", 33));
		list.add(new Person("이영희", 17));
		list.add(new Person("홍길동", 20));
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
		
		System.out.println(list.contains(new Person("홍길동", 20)));
		System.out.println(list.indexOf(new Person("홍길동", 20)));
		System.out.println(list.lastIndexOf(new Person("홍길동", 20)));
		list.remove(1);//정수면 인덱스로 삭제
		list.remove(new Person("홍길동", 20));//객체 비교로 삭제
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
		
	}

}







