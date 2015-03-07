package interfaces.stoppuhren;

public class SwissTickZero extends SwissTick implements ResettableStopWatch{

	@Override
	public void reset() {
		setTime(0);
	}

}
