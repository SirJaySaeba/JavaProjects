package interfaces.stoppuhren;

public class StopWatchApp {

	public static void main(String[] args) throws InterruptedException {
		SuspendableStopWatch a = new SwissTickDeluxe();
		Thread.sleep(100);
		
		System.out.println(a);
		
		a.suspend();
		Thread.sleep(100);
		
		System.out.println(a);
		a.resume();
		
		Thread.sleep(100);
		
		System.out.println(a);
		
	}

}
