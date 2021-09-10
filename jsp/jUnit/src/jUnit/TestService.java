package jUnit;

public class TestService {
	private static TestService instance = new TestService();

	private TestService() {
	}

	public static TestService getInstance() {
		if(instance == null)
			instance = new TestService();
		return instance;
	}
	
	public int rectArea(int w, int h) {
		return w*h;
	}
	
	public boolean equalsNumber(int n1, int n2) {
		return n1 == n2;
	}
	
}



