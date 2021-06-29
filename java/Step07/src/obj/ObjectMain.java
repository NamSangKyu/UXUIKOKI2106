package obj;

public class ObjectMain {

	public static void main(String[] args) {
		Person p = new Person("홍길동", 20);
		Person t = p;
		System.out.println(p);
		String str = "Person의 내용 > ";
		System.out.println(str + p);
		Person s = new Person("홍길동", 20);
		System.out.println(p==t);
		System.out.println(p.equals(s));
	}

}
