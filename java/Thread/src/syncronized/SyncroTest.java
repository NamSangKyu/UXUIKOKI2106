package syncronized;

public class SyncroTest {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Player p1 = new Player(bank);
		Player p2 = new Player(bank);
		
		p1.start();
		p2.start();
		
	}

}
