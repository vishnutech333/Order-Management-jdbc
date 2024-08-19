package model;

public class Product {
	private int prodID;

	private String prodName;

	private int price;

	private int quan;

	private String category;

	public int getProdID() {
		return prodID;

}

	public String getProdName() {

		return prodName;

	}

	public void setProdName(String prodName) {

		this.prodName = prodName;

	}

	public int getPrice() {

		return price;

	}

	public void setPrice(int price) {

		this.price = price;

	}

	public int getQuan() {

		return quan;

	}

	public void setQuan(int quan) {

		this.quan = quan;

	}

	public String getCategory() {

		return category;

	}

	public void setCategory(String category) {

		this.category = category;

	}

	public void setProdID(int prodID) {

		this.prodID = prodID;

	}
}
