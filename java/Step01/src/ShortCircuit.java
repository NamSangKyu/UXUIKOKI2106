
public class ShortCircuit {
	//단락 회로
	public static void main(String[] args) {
		boolean flag = false;
		int n1=10, n2=20;
		flag = n1 < 10 && ++n2 == 20;
		System.out.println(n2);
		flag = n1 == 10 || ++n2 == 20;
		System.out.println(n2);
	}

}
