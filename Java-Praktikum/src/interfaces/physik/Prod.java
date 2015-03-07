package interfaces.physik;

public class Prod <U extends Unit,V extends Unit> implements Unit {

	private final U fst;
	private final V snd;
		
	public Prod(U fst, V snd) {
		this.fst = fst;
		this.snd = snd;
	}

	@Override
	public double getBaseUnits() {
		return 654;
	}
	
	@Override
	public String toString(){
		return fst+"*"+snd;
	}

}
