package interfaces.physik;

public enum Length implements Unit {
	m(1), cm(100), ft(0.3048), km(1000), mi(1632.9), LY(9.461E15), A(1E-10);
	
	private final double baseUnits;
	
	private Length(double val){
		baseUnits = val;
	}

	public double getBaseUnits() {
		return baseUnits;
	}
	
	
}
