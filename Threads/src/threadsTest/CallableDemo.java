package threadsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableDemo implements Callable<List<Integer>> {

	private int number;

	public CallableDemo(int number) {
		this.number = number;
	}

	@Override
	public List<Integer> call() throws Exception {
		List<Integer> primesFacVector = new ArrayList<>();

		int x = number / 2;

		for (int i = 2; i <= x; i++) {
			while (number % i == 0) {
				primesFacVector.add(i);
				number = number / i;
			}
		}

		return primesFacVector;
	}

}
