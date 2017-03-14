package sudoku_validator;

import java.util.Scanner;

public class Sudoku {
	
	private String valid = "1 2 3 4 5 6 7 8 9 4 5 6 7 8 9 1 2 3 7 8 9 1 2 3 4 5 6 2 3 1 6 4 5 9 7 8 6 4 5 9 7 8 2 3 1 9 7 8 2 3 1 6 4 5" + 
			"3 1 2 5 6 4 8 9 7 5 6 4 8 9 7 3 1 2 8 9 7 3 1 2 5 6 4 ";

	private final int SIZE = 9;
	private int[][] matrix = new int[SIZE][SIZE];

	public Sudoku() {
		Scanner input = new Scanner(System.in);
		// Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				matrix[i][j] = input.nextInt();
				// matrix[i][j] = r.nextInt(9) + 1;
			}
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getValue(int x, int y) {
		return matrix[x][y];
	}

	public void print() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
