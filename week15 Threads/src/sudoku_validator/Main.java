package sudoku_validator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {


	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Sudoku s = new Sudoku();
		s.print();
		
		Callable<Boolean> rowTask = new CheckRows(s);
		Callable<Boolean> colTask = new CheckCols(s);
		Callable<Boolean> innerSqrTask = new CheckInnerSquares(s);
		
		ExecutorService exeService = Executors.newCachedThreadPool();
		
		Future<Boolean> rows = exeService.submit(rowTask);
		Future<Boolean> cols = exeService.submit(colTask);
		Future<Boolean> innerSqr = exeService.submit(innerSqrTask);
		
		if(rows.get() && cols.get() && innerSqr.get()) {
			System.out.println("Sudoku is correct");
		}else {
			System.out.println("Sudoku is incorrect");
		}
		
		exeService.shutdown();
		
	}
}
