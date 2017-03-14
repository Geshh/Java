package synchronized_keyword;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class LostUpdateExample2 {

	private static AtomicInteger counter = new AtomicInteger(0);

	private static class Incrementer implements Callable<AtomicInteger> {

//		private static synchronized void incrementCounter() {
//			counter.getAndIncrement();
//		}

		@Override
		public AtomicInteger call() throws Exception {
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (counter) {
					counter.getAndIncrement();
				}
				//incrementCounter();
			}
			return counter;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		List<Callable<AtomicInteger>> tasks = Arrays.asList(new Incrementer(), new Incrementer(), new Incrementer());
		service.invokeAll(tasks);

		service.shutdown();

		System.out.println(counter);

	}

}
