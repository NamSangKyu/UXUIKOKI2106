
public class Date1{

	public static void main(String[] args) {
		long start =System.nanoTime();
		long mstart =System.currentTimeMillis(); 
		
		long a = 0l;
		for(int i=0;i<100000000;i++) {
			a+=i;
		}
		
		
		long end =System.nanoTime();
		long mend=System.currentTimeMillis(); 
		System.out.println(end - start);
		System.out.println(mend - mstart);
	}

}
