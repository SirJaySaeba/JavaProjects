import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Checkout {

	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public static void main(String[] args) {
		final Product p1 = new Product("Schnuff", 1.99);
		final Product p2 = new Product("N64", 299);
		final Product p3 = new Product("Canton Ergo DC 620", 450);
		final Product p4 = new Product("Glasses", 24.99);
		final Product p5 = new Product("TV", 59);
		
		Cart cart1 = new Cart();
		Cart cart2 = new Cart();
		Cart cart3 = new Cart();
		
		List<Product> productGroup1 = new ArrayList<>();
		List<Product> productGroup2 = new ArrayList<>();
		List<Product> productGroup3 = new ArrayList<>();

		productGroup1.add(p1);
		productGroup1.add(p2);
		productGroup1.add(p3);
		productGroup2.add(p4);
		productGroup2.add(p5);
		productGroup3.add(p2);
		productGroup3.add(p5);
		
		cart1.setProducts(productGroup1);
		cart2.setProducts(productGroup2);
		cart3.setProducts(productGroup3);
		List<Order> orders = new ArrayList<>();
		
		Order order1 = new Order(cart1, new Date(2001,01,20));
		Order order2 = new Order(cart2, new Date(1999,02,21));
		Order order3 = new Order(cart3, new Date(2003,03,22));
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setOrders(orders);
		
		sortOrders(orderHistory);
		
	}
	
	private static void sortOrders(OrderHistory orderHistory){

	}

}
