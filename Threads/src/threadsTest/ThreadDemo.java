package threadsTest;

public class ThreadDemo implements Runnable {

	private int number;

	ThreadDemo(int number) {
		this.number = number;
	}

	@Override
	public void run() {

		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println(Thread.currentThread().getName());
		
		
		int x = number/2;
		
		for (int i = 2; i <= x; i++) {
			
			while (number % i == 0) {
				System.out.println(i);
				number = number / i;
			}
		}

	}

}
