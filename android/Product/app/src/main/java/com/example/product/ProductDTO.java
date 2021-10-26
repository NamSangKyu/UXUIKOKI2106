package com.example.product;

public class ProductDTO {
	private String pno;
	private String pname;
	private String maker;
	private int price;
	public ProductDTO(String pno, String pname, String maker, int price) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.maker = maker;
		this.price = price;
	}
	public ProductDTO() {
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
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
