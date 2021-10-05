package init;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadRun run1 = new ThreadRun("스레드1");
		ThreadRun run2 = new ThreadRun("스레드2");
		ThreadRun run3 = new ThreadRun("스레드3");
		ThreadRun run4 = new ThreadRun("스레드4");
		
		run1.start(); //스레드가 스케줄러에 자동 등록
		run2.start();
		run3.start();
		run4.start();
		
		System.out.println("main thread exit");
	}

}
