package ziegenproblem;

public class Price{

	private boolean status;
	private final String name;
	
	Price(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void reveal(boolean status) {
		this.status = status;
	}

	public boolean revealed() {
		return status;
	}

}
