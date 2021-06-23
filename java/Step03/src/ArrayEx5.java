
public class ArrayEx5 {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };

		for (int i = 0; i < arr1.length; i++)
			System.out.println(arr1[i]);

		int temp[] = arr1; // temp와 arr1 동일한 배열
		arr1[0] = 100;
		System.out.println(arr1[0]);
		System.out.println(temp[0]);

		arr1 = new int[] { 5, 4, 6, 3, 7, 2 };// 새 배열을 만들고 arr1에 연결
		for (int i = 0; i < arr1.length; i++)
			System.out.println(arr1[i]);
		for (int i = 0; i < temp.length; i++)
			System.out.println(temp[i]);

	}

}
