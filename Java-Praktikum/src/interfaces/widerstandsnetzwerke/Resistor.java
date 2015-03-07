package interfaces.widerstandsnetzwerke;

public class Resistor implements Circuit {

	private final double ohm;

	Resistor(double ohm){
		this.ohm = ohm;
	}
	
	@Override
	public double getOhm() {
		return ohm;
	}

	@Override
	public int numberOfResistors() {
		return 1;
	}
}
