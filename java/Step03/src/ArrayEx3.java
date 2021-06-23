
public class ArrayEx3 {

	public static void main(String[] args) {
		//배열 생성시 기본값을 저장 : 0, 0.0, false, null
		//int형 길이가 5인 배열 생성 
		int[] arr1 = new int[5];
		//double형 길이가 5인 배열 생성 
		double[] arr2 = new double[5];
		//boolean형 길이가 5인 배열 생성 
		boolean[] arr3 = new boolean[5];
		//String형 길이가 5인 배열 생성
		String[] arr4 = new String[5];
		//각 배열의 값을 전부 출력
		for(int i=0;i<arr1.length;i++)
			System.out.println(arr1[i]);
		for(int i=0;i<arr2.length;i++)
			System.out.println(arr2[i]);
		for(int i=0;i<arr3.length;i++)
			System.out.println(arr3[i]);
		for(int i=0;i<arr4.length;i++)
			System.out.println(arr4[i]);
		
	}

}
