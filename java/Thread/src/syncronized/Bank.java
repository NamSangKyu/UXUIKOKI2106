package syncronized;

public class Bank {

	private int money;
	
	public Bank() {
		money = 1000;
	}
	
	public synchronized int transMoney(int money)  {
		this.money += money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.money;
				
	}
	
}
