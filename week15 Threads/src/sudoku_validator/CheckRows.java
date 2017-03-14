package sudoku_validator;

import java.util.concurrent.Callable;

public class CheckRows implements Callable<Boolean> {

	private Sudoku sudoku;

	public CheckRows(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	@Override
	public Boolean call() throws Exception {
		Boolean result = new Boolean(true);

		int[] frequencies = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				int val = sudoku.getValue(i, j);

				frequencies[val-1] += 1;

				if (frequencies[val-1] > 1) {
					result = false;
				}
			}
			frequencies = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		}

		return result;
	}

}
