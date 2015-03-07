package interfaces.widerstandsnetzwerke;

public class Potenziometer implements Circuit {

	private double ohm;
	private final double maxOhm;
	
	public Potenziometer(double maxOhm) {
		this.maxOhm = maxOhm;
		this.ohm = maxOhm;
	}

	@Override
	public double getOhm() {
		return ohm;
	}

	@Override
	public int numberOfResistors() {
		// TODO Auto-generated method stub
		return 1;
	}
	

	public void setOhm(double ohm){
		if(ohm>maxOhm){
			this.ohm = maxOhm;
		}else if(ohm<0){
			this.ohm = 0;
		}else{
			this.ohm = ohm;
		}
	}

}
