package init;

public class ThreadRun extends Thread{
		
	public ThreadRun(String name) {
		super(name);
		System.out.println(name + "스레드 생성");
	}

	@Override
	public void run() {//자동으로 수행할 메서드
		for(int i=0;i<1000000;i++);
		
		System.out.println(getName() + "스레드 종료");
	}

	
}
