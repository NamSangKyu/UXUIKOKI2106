package staticex;

import java.util.Random;

public class CardFactory {
	private static int cardNo = 1000;
	private static CardFactory instance = new CardFactory();
	
	private CardFactory() {
		
	}
	
	public static CardFactory getInstance() {
		if(instance == null)
			instance = new CardFactory();
		return instance;
	}
	
	public Card createCard(String name) {
		Random r = new Random();
		// 22 ~ 25
		int month = (r.nextInt(12) + 1);
		String date = (month < 10 ? "0" + month : month) + "/" + (r.nextInt(4) + 22);
		return new Card(cardNo++, name, date);
	}
}
