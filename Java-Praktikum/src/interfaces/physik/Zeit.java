package interfaces.physik;

public enum Zeit implements Unit{

	s(1), d(24*3600), yr(365*24*3600), ns(0.000000001);

	private final double baseUnits;
	
	Zeit(double baseUnits){
		this.baseUnits = baseUnits;
	}
	
	@Override
	public double getBaseUnits() {
		return baseUnits;
	}
	
	
}
