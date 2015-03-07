package interfaces.widerstandsnetzwerke;

public class Parallel extends CompoundCircuit {

	
	Parallel(Circuit circuit1, Circuit circuit2){
		super(circuit1,circuit2);
	}
	
	
	@Override
	public double getOhm() {
		return 1/(1/getCircuit1().getOhm()+1/getCircuit2().getOhm());
	}
}
