package interfaces.widerstandsnetzwerke;

public abstract class CompoundCircuit implements Circuit{

	private final Circuit circuit1;
	private final Circuit circuit2;
	
	protected CompoundCircuit(Circuit circuit1, Circuit circuit2) {
		this.circuit1 = circuit1;
		this.circuit2 = circuit2;
	}

	protected Circuit getCircuit1() {
		return circuit1;
	}

	protected Circuit getCircuit2() {
		return circuit2;
	}
	
	@Override
	public int numberOfResistors(){
		return circuit1.numberOfResistors()+circuit2.numberOfResistors();
	}
	
}
