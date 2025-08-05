package org.miaoubich.streamapi;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private String orderId;
	private List<Product> products;
	private double totalValue;
	private LocalDateTime orderTime;
	
	public Order(String orderId, List<Product> products, double totalValue, LocalDateTime orderTime) {
		this.orderId = orderId;
		this.products = products;
		this.totalValue = totalValue;
		this.orderTime = orderTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", totalValue=" + totalValue + ", orderTime="
				+ orderTime + "]";
	}
	
}
