package signalling;

import java.util.concurrent.locks.ReentrantLock;

public class HackSignal {

	// private Object obj = new Object();
	private ReentrantLock lock;
	private String obj = "Hello";
	private boolean wasSignalled = false;

	public void doWait() {
		try {
			lock.lock();
			while (!wasSignalled) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void doNotify() {
		try {
			lock.lock();
			while (!wasSignalled) {
				wasSignalled = true;
				lock.notify();
			}
		} finally {
			lock.unlock();
		}
	}
}
