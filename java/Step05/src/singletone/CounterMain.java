package singletone;

public class CounterMain {

	public static void main(String[] args) {
//		Counter c = new Counter();
		Counter c = Counter.getInstance();
		Counter.getInstance();
		Counter.getInstance();
		Counter.getInstance();
		Counter.getInstance();
		Counter.getInstance();
	}

}
