package interfaces.stoppuhren;

public class SwissTickDeluxe extends SwissTickZero implements SuspendableStopWatch {

	private boolean suspended;
	private long suspendedAt;
	
	
	public SwissTickDeluxe() {
		super();
		suspended = false;
	}

	@Override
	public void suspend() {
		
		if(!suspended){
			suspendedAt = read();
			suspended = true;
		}
		
	}

	@Override
	public void resume() {
		if(suspended){
			setTime(suspendedAt);
			suspended = false;
		}
	}
	
	@Override
	public long read() {
		if(suspended){
			return suspendedAt;
		}	
		return super.read();		
		
	}
	
	@Override
	public void syncTo(BaseStopWatch sw) {
		if(suspended){
			suspendedAt = sw.read();
		}			
		super.syncTo(sw);
		
	}
	
	@Override
	public void reset() {
		if(suspended){
			suspendedAt = 0;
		}
		super.reset();
	}
}
