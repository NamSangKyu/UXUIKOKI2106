
public class Clothes {
	//브랜드
	String brand;
	//제품명
	String product;
	//옷 종류
	int kind;
	//계절
	int season;
	//성별
	boolean gender;
	//사이즈
	int size;
	//색상
	int color;
	//금액
	int price;
	//재고
	int ea;
	
	public Clothes(String brand, String product, int kind, int season, boolean gender, int size, int color, int price,
			int ea) {
		super();
		this.brand = brand;
		this.product = product;
		this.kind = kind;
		this.season = season;
		this.gender = gender;
		this.size = size;
		this.color = color;
		this.price = price;
		this.ea = ea;
	}
	
}


