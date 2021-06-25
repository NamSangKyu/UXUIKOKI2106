package staticex;

import java.util.Random;

public class CardFactory {
	private static int cardNo = 1000;
	
	public Card createCard(String name) {
		Random r = new Random();
		//22 ~ 25
		String date = (r.nextInt(12)+1) +"/" + (r.nextInt(4)+22);
		return new Card(cardNo++, name, date);
	}
}
