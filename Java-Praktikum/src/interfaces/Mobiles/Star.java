package interfaces.Mobiles;

public class Star implements Mobile {


	private final double weight;
	
	public Star(double weight) {
		if(weight <= 0){
			throw new IllegalArgumentException("Was fuer ein Stern soll das denn sein??? Er kann gar nicht "+weight+" wiegen X.x");
		}
		this.weight = weight;
	}

	@Override
	public double weight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String toString(){
		return String.format("STAR[%f]", weight);
	}
	
	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	}

}
