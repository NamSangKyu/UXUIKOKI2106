
public class ArrayEx2 {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		for(int i=0,num=10;i<5;i++,num+=10)
			arr1[i] = num;
		
		for(int i=0;i<5;i++)
			System.out.println(arr1[i]);
		
		int[] arr2 = new int[10];
		for(int i=0;i<arr2.length;i++)
			arr2[i] = (i+1) * 2;
		
		for(int i=0;i<arr2.length;i++)
			System.out.println(arr2[i]);
		
	}

}










