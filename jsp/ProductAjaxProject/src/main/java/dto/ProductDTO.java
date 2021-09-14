package dto;

public class ProductDTO {
	private String productNo;
	private String productName;
	private int price;
	private int ea;
	private String maker;
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String productNo, String productName, int price, int ea, String maker) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.ea = ea;
		this.maker = maker;
	}

	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", ea=" + ea
				+ ", maker=" + maker + "]";
	}
	
	
}
