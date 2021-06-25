package staticex;

public class CardMain {

	public static void main(String[] args) {
		CardFactory factory = new CardFactory();
		
		Card card1 = factory.createCard("홍길동");
		Card card2 = factory.createCard("김철수");
		Card card3 = factory.createCard("이영희");
		
		card1.printCardInfo();
		card2.printCardInfo();
		card3.printCardInfo();

	}

}
