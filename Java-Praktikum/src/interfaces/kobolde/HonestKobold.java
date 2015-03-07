package interfaces.kobolde;

public class HonestKobold extends Kobold{

	private long honestyends = 0;
	
	public HonestKobold(String name, Behaviour... behaviour) {
		super(name, behaviour);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public int messUp(int i) {
		if(System.currentTimeMillis() < honestyends){
			return i;
		}
		return super.messUp(i);
	}



	public void beHonestFor(long i){
		honestyends = System.currentTimeMillis()+i;
	}

}
