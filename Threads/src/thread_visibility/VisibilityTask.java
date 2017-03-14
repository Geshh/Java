package thread_visibility;

public class VisibilityTask implements Runnable {

	private volatile boolean keepRunning = true;
	
	public void setToFalse() {
		keepRunning = false;
	}
	
	public boolean getValue() {
		return keepRunning;
	}

	@Override
	public void run() {

		while(getValue()) {
			System.out.println("Working");
		}
		System.out.println("Im done");
	}

}
