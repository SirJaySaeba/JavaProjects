package interfaces.stoppuhren;

public class SwissTick implements BaseStopWatch{

	private long startTime;
	
	SwissTick(){
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public long read() {
		return System.currentTimeMillis() - startTime;
	}

	@Override
	public void syncTo(BaseStopWatch sw) {
		startTime = System.currentTimeMillis() - sw.read();
	}
	
	public String toString(){
		return Long.toString(read());
	}
	
	protected void setTime(long time){
		startTime = System.currentTimeMillis() - time;
	}

}
