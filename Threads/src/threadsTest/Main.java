package threadsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		List<Callable<List<Integer>>> lst = new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			lst.add(new CallableDemo(100000));
		}

		ExecutorService exeService = Executors.newCachedThreadPool();
		long begin = System.currentTimeMillis();
		try {
			exeService.invokeAll(lst);
			exeService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);

		// Runnable task = new ThreadDemo(44);
		// // Thread thread = new Thread(task, "First thread");
		//
		// Runnable task2 = new ThreadDemo(56);
		// // Thread thread2 = new Thread(task2, "Second thread");
		//
		// ExecutorService executorService = Executors.newCachedThreadPool();
		//
		// // executorService.execute(task);
		// // executorService.execute(task2);
		// // executorService.shutdown();
		//
		// Future<?> exeFuture = executorService.submit(task2);
		// try {
		// System.out.println(exeFuture.get());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// //
		// ---------------------------------------------------------------------
		//
		// Callable<List<Integer>> task3 = new CallableDemo(56);
		// Future<List<Integer>> future = executorService.submit(task3);
		//
		// try {
		// System.out.println(future.get());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// // Future future = executorService.submit(thread);
		// //
		// // try {
		// // System.out.println(future.get());
		// // } catch (InterruptedException e) {
		// // // TODO Auto-generated catch block
		// // e.printStackTrace();
		// // } catch (ExecutionException e) {
		// // // TODO Auto-generated catch block
		// // e.printStackTrace();
		// // }
		//
		// // Future future = executorService.submit(new Callable() {
		// // @Override
		// // public Object call() throws Exception {
		// // System.out.println("Some callable task");
		// // return "Callable Result";
		// // }
		// // });
		//
		// ExecutorService exeService = Executors.newSingleThreadExecutor();

	}
}
