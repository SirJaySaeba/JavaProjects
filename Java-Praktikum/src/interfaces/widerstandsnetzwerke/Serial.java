package interfaces.widerstandsnetzwerke;

public class Serial extends CompoundCircuit {
	
	protected Serial(Circuit circuit1, Circuit circuit2) {
		super(circuit1, circuit2);

	}

	@Override
	public double getOhm() {
		return getCircuit1().getOhm()+getCircuit2().getOhm();
	}
}
