package staticex;

public class CardMain {

	public static void main(String[] args) {
//		CardFactory factory = new CardFactory();
		CardFactory factory = CardFactory.getInstance();
				
		Card card1 = factory.createCard("홍길동");
		Card card2 = factory.createCard("김철수");
		Card card3 = factory.createCard("이영희");
		Card card4 = CardFactory.getInstance().createCard("박홍수");
		
		card1.printCardInfo();
		card2.printCardInfo();
		card3.printCardInfo();
		card4.printCardInfo();

	}

}
