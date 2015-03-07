package interfaces.physik;

public class Ratio <U extends Unit,V extends Unit> implements Unit{

	private final U fst;
	private final V snd;
		
	public Ratio(U fst, V snd) {
		this.fst = fst;
		this.snd = snd;
	}

	@Override
	public double getBaseUnits() {
		return fst.getBaseUnits()*snd.getBaseUnits();
	}
	
	@Override
	public String toString(){
		return fst+"*"+snd;
	}

}
