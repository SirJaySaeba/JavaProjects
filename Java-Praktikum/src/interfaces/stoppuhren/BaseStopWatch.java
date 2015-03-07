package interfaces.stoppuhren;

public interface BaseStopWatch {

	
	public long read();
	public void syncTo(BaseStopWatch sw);
}
