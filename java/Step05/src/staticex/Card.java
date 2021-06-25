package staticex;

public class Card {
	private int cardNo;
	private String name;
	private String date;
	
	public Card(int cardNo, String name, String date) {
		this.cardNo = cardNo;
		this.name = name;
		this.date = date;
	}

	public void printCardInfo() {
		System.out.println(cardNo + " " + name + " " + date);
	}
	
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
