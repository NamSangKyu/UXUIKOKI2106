package ex1;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		for(int i=0;i<6;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("프로그램 종료");
	}

}
