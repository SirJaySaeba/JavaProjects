package interfaces.physik;

public enum Masse implements Unit{

	kg(1), g(0.001), lb(0.4536), Kt(0.0002);
	
	private final double baseUnits;

	Masse(double base){
		this.baseUnits = base;
	}
	
	@Override
	public double getBaseUnits() {
		// TODO Auto-generated method stub
		return baseUnits;
	}
	
	
}
