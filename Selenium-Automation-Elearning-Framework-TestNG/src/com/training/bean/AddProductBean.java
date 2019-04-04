package com.training.bean;

public class AddProductBean {
	private String productname;
	private String metatag;
	private String model;
	private String price;
	private String quantity;
	private String category;
	private String discountquantity;
	private String discountprice;
	private String points;
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getMetatag() {
		return metatag;
	}

	public void setMetatag(String metatag) {
		this.metatag = metatag;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDiscountquantity() {
		return discountquantity;
	}

	public void setDiscountquantity(String discountquantity) {
		this.discountquantity = discountquantity;
	}

	public String getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(String discountprice) {
		this.discountprice = discountprice;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	

	public AddProductBean() {
	}

	public AddProductBean(String productname, String metatag, String model, String price, String quantity,
			String category, String discountquantity, String discountprice, String points) {
		super();
		this.productname = productname;
		this.metatag = metatag;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.discountquantity = discountquantity;
		this.discountprice = discountprice;
		this.points = points;
	}

	
	@Override
	public String toString() {
		return "LoginBean [productname=" + productname + ", metatag=" + metatag + ",model=" + model+",price="+ price +", quantity="+ quantity +", category="+ category +", "
				+ "discountquantity="+ discountquantity +", discountprice=" + discountprice +",points=" + points + "]";
	}

}
