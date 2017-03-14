package sudoku_validator;

import java.util.concurrent.Callable;

public class CheckInnerSquares implements Callable<Boolean> {

	private Sudoku sudoku;

	public CheckInnerSquares(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	@Override
	public Boolean call() throws Exception {
		Boolean result = new Boolean(true);

		int[] frequencies = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {

				for (int k = 0; k < 3; k++) {
					for (int m = 0; m < 3; m++) {

						int val = sudoku.getValue(k + i, m + j);

						frequencies[val - 1] += 1;

						if (frequencies[val - 1] > 1) {
							result = false;
							break;
						}
					}
				}
				frequencies = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			}
		}

		return result;
	}

}
