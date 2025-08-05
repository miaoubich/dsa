package org.miaoubich.streamapi;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Top Java 8 scenario based interview questions
 * 
 * .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingLong(Product::getQuantity)))
								.entrySet().stream()
								.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
								.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

Scenario:

You're working on the backend of an e-commerce platform. The system fetches a list of all orders placed in the last 24 hours. 
 Each order has a list of products, and each product belongs to a category.

Now, you are asked to generate a report that shows, for each product category, the total quantity of items sold but:

Only include orders where the total value is more than $500, and

Exclude any product that is marked as "out of stock" (even if it was part of the order),

The report must be sorted by total quantity in descending order.

Question:

How would you approach writing this logic using Java 8 Streams, keeping performance and readability in mind?
 * 
 * */

public class StreamInterviewQ1 {

	public static void main(String[] args) {
		List<Order> orders = fetchOrders();
		
		/* 
		 * 
			 List of Orders placed in the last 24 hours (orderTime = now()-24h)
			 orders where the total value is more than $500 (totalValue > 500)
			 at least one product per order (inStock = true)
			 Each product belongs to a category (groupBy category)
		 *
		 */
//		Map<String, Long> orderReport = 
				orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
				.filter(order -> order.getTotalValue() > 500)
				.flatMap(order -> order.getProducts().stream())
								.filter(product -> product.isInStock())
								.collect(Collectors.groupingBy(Product::getCategory, Collectors.summingLong(Product::getQuantity)))
								.entrySet()
		        .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
								
								
		
	}

	private static List<Order> fetchOrders() {
		return //new ArrayList<Order>(
				Arrays.asList(
						new Order("1",
								Arrays.asList(new Product("P1", "Product 1", "Electronics", 2, true, 300),
										new Product("P2", "Product 2", "Electronics", 3, true, 200)),
								500.0, LocalDateTime.now().minusHours(1)),
						new Order("2",
								Arrays.asList(new Product("P3", "Product 3", "Books", 5, true, 100),
										new Product("P4", "Product 4", "Books", 1, false, 50)),
								600.0, LocalDateTime.now().minus(Period.ofDays(1))),
						new Order("3", Arrays.asList(new Product("P5", "Product 5", "Clothing", 10, true, 700),
								new Product("P6", "Product 6", "Clothing", 2, true, 200)), 900.0, LocalDateTime.now().minusDays(2)),
						new Order("4", Arrays.asList(new Product("P5", "Product 5", "Clothing", 10, true, 700),
								new Product("P7", "Product 7", "TV", 1, true, 250)), 800.0, LocalDateTime.now().minusHours(23)));//);
	}

}
