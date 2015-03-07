package interfaces.Mobiles;

public class Wire implements Mobile{

	private final Mobile first;
	private final Mobile second;
	private double distanceFirst;
	private double distanceSecond;
	
	public Wire(Mobile first, Mobile second, double length) {
		if(first == null || second == null){
			throw new IllegalArgumentException("Die Mobiles muss es aber auch schon geben!");
		}
		this.first = first;
		this.second = second;
		distanceFirst = 0.0d;
		distanceSecond = length;
	}

	@Override
	public double weight() {

		return first.weight()+second.weight();
	}

	@Override
	public void balance() {
		first.balance();
		second.balance();
		double w1 = first.weight();
		double w2 = second.weight();
		
		double length = distanceFirst + distanceSecond;
		distanceFirst = w2*length/(w1+w2);
		distanceSecond = w1*length/(w1+w2);
	}
	
	@Override
	public String toString(){
		
		return String.format("Star[%g:%s, %g:%s]",distanceFirst, first.toString(),distanceSecond, second.toString());
	}
}
