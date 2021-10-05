package join;

public class JoinTest {

	public static void main(String[] args) {
		JoinThread t1 = new JoinThread("스레드1");
		
		try {
			t1.start();
			t1.join();//main 스레드가 t1 스레드가 끝날때까지 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread exit");
	}

}
