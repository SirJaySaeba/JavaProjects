import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order>, Comparator<Order>{

	private Date orderDate;
	private List<Product> products;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Order(Cart cart, Date orderDate) {
		this.products = cart.getProducts();
		this.orderDate = orderDate;
	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Order arg0, Order arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
