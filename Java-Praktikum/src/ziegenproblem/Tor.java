package ziegenproblem;

public class Tor{

	private boolean isOpen;
	private Price price;
	private final int gateNumber;

	public int getGateNumber() {
		return gateNumber;
	}

	Tor(int gateNumber){
		this.gateNumber = gateNumber;
		this.price = new Zonk();
	}
	
	public void setPrice(Price price){
		this.price = price;
	}
	
	public Price getPrice() {
		return price;
	}

	public void openGate() {
		if(isOpen){
			System.out.println("Already Open");
		}else{
			price.reveal(true);
			isOpen = true;
		}
	}
	
	public boolean isOpen() {
		return isOpen;
	}

	
}
