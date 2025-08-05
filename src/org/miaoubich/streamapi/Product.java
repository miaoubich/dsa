package org.miaoubich.streamapi;

public class Product {

	private String productId;
	private String name;
	private String category;
	private int quantity;
	private boolean inStock;
	private double price;
	
	public Product(String productId, String name, String category, int quantity, boolean inStock, double price) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.inStock = inStock;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", quantity="
				+ quantity + ", inStock=" + inStock + ", price=" + price + "]";
	}
	
}
