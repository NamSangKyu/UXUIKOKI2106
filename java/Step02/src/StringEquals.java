
public class StringEquals {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = str1;
		String str3 = new String("Hello");
		String str4 = "Hello";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);

		System.out.println("----------------");
		//내용 비교
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str4));
		
	}

}






