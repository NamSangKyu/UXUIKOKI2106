package priority;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadPriority run1 = new ThreadPriority("1번 스레드");
		ThreadPriority run2 = new ThreadPriority("2번 스레드");
		ThreadPriority run3 = new ThreadPriority("3번 스레드");
		ThreadPriority run4 = new ThreadPriority("4번 스레드");
		run1.setPriority(Thread.MIN_PRIORITY);
		run2.setPriority(Thread.MIN_PRIORITY);
		run3.setPriority(Thread.MIN_PRIORITY);
		run4.setPriority(Thread.MAX_PRIORITY);
		run1.start();
		run2.start();
		run3.start();
		run4.start();
		
		System.out.println("main thread exit");
	}

}
