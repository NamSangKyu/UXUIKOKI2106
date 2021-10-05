package init;

public class RunnableTest {

	public static void main(String[] args) {
		RunnableRun run1 = new RunnableRun();
		RunnableRun run2 = new RunnableRun();
		RunnableRun run3 = new RunnableRun();
		RunnableRun run4 = new RunnableRun();
		Thread th1 = new Thread(run1,"스레드1");
		Thread th2 = new Thread(run2,"스레드2");
		Thread th3 = new Thread(run3,"스레드3");
		Thread th4 = new Thread(run4,"스레드4");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		System.out.println("main thread exit");
	}

}
