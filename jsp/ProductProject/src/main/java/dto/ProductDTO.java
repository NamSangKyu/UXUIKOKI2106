package dto;

public class ProductDTO {
	private String pno;
	private String pname;
	private int price;
	private String maker;
	public ProductDTO(String pno, String pname, int price, String maker) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.maker = maker;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "ProductDTO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", maker=" + maker + "]";
	}
	
}
