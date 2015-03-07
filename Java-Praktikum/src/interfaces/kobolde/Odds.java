package interfaces.kobolde;

public class Odds implements Behaviour {

	private final Behaviour other;

	public Odds(Behaviour other) {
		this.other = other;
	}

	@Override
	public int modify(int i) {
		if(i%2!=0){
			i = other.modify(i);
		}
		return i;
	}
	
	
	
}
