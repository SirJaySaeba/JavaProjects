package interfaces.kobolde;

public class Delay implements Behaviour {

	
	private final int delay;
	
	Delay(int delay){
		this.delay = Math.max(0, Math.min(10, delay));
	}
	
	@Override
	public int modify(int i) {

		try{
			Thread.sleep(1000*delay);
		}catch(InterruptedException ie){
			
		}
		return i;
	}

}
