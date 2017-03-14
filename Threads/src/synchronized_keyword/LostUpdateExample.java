package synchronized_keyword;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LostUpdateExample {

	private static volatile long counter = 0;

	private static class Incrementer implements Callable<Long> {

		private static synchronized void incrementCounter() {
			counter++;
		}

		@Override
		public Long call() throws Exception {
			for (int i = 0; i < 1_000_000; i++) {
				incrementCounter();
			}
			return counter;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		List<Callable<Long>> tasks = Arrays.asList(new Incrementer(), new Incrementer(), new Incrementer());
		service.invokeAll(tasks);

		service.shutdown();

		System.out.println(counter);

	}

}
