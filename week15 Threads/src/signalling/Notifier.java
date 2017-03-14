package signalling;

import java.util.concurrent.ThreadLocalRandom;

public class Notifier implements Runnable {

	private Signal s;

	public Notifier(Signal s) {
		this.s = s;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("Notifier");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.threadMsg("LEL");
	}

}
