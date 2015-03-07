package interfaces.kobolde;

public class Blur implements Behaviour {

	private final int schabernack;
	
	Blur(int schabernack){
		this.schabernack = Math.max(0, Math.min(10, schabernack));
	}
	
	@Override
	public int modify(int i) {
		return (int)(i+(schabernack+1)*Math.random());
	}

}
