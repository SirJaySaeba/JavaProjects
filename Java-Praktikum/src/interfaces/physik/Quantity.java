package interfaces.physik;

public class Quantity<U extends Unit> {

	private final double count;
	private final U unit;
	
	public Quantity(double value, U unit) {
		this.count = Math.abs(value);
		
		this.unit = unit;
	}

	public Quantity<U> add(Quantity<U> quantity){
		double newDist = downToBaseUnit() + quantity.unit.getBaseUnits()*quantity.count;
		newDist = newDist/this.unit.getBaseUnits();
		return new Quantity<>(newDist, this.unit);
	}
	
	public double getCount() {
		return count;
	}

	public Unit getUnit() {
		return unit;
	}
	
	public String toString(){
		return count+ " "+ unit;
	}

	private double downToBaseUnit(){
		return unit.getBaseUnits()*count;
	}
	
	public Quantity<U> as(U newUnit){
		double newQuantity = downToBaseUnit()/newUnit.getBaseUnits();
		return new Quantity<>(newQuantity, newUnit);
	}
	
	public <V extends Unit> Quantity<Prod<U,V>> by(Quantity<V> qty){
		Prod<U,V> product =new Prod<>(this.unit,qty.unit);
		double result = count*qty.count;
		
		return new Quantity<>(result, product);
	}

}
