package syncronized;

public class Player extends Thread{

	private int money;
	private Bank bank;
	
	public Player(Bank bank) {
		super();
		this.bank = bank;
	}
	
	public void getMoney() {
		money = bank.transMoney(1000);
		System.out.println(getName() + " : "+
		money);
	}
	
	@Override
	public void run() {
		getMoney();
	}
}


