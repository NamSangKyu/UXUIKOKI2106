package set;

import java.util.HashSet;
import java.util.Iterator;

import obj.Person;

public class PersonSetTest {

	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("홍길동", 20));
		set.add(new Person("김철수", 33));
		set.add(new Person("이영수", 41));
		set.add(new Person("박영희", 23));
		set.add(new Person("홍길동", 20));
		
		//전체 출력
		Iterator<Person> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		//해당 객체가 있는 체크
		System.out.println(set.contains(new Person("홍길동", 20)));
		
	}

}





