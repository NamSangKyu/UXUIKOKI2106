package init;

public class RunnableRun implements Runnable {
	
	
	public RunnableRun() {	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 1000000; i++);

		System.out.println(name + "스레드 종료");
	}

}
