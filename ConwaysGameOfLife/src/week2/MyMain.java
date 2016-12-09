package week2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyMain {
	static final int matrixDim = 19;
	static final String fullSqr = " ■ ";
	static final String emptySqr = " □ ";

	public static void printMatrix(String[][] matr) {
		String result = "";
		for (int i = 0; i < matrixDim; i++) {
			for (int j = 0; j < matrixDim; j++) {
				result += matr[i][j];
			}
			result += "\n";
		}
		System.out.println(result);
	}

	private static boolean isCellAlive(int x, int y, String[][] matrix) {
		return (matrix[x][y] == fullSqr);
	}

	public static void killSqr(int x, int y, String[][] matrix) {
		matrix[x][y] = emptySqr;
	}

	public static void reviveSqr(int x, int y, String[][] matrix) {
		matrix[x][y] = fullSqr;
	}

	public static int aliveNeighboursCount(int x, int y, String[][] matrix) {
		int count = 0;

		int[] i = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] j = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int k = 0; k < 8; k++) {
			int oppositeX = Math.floorMod(x + i[k], matrixDim);
			int oppositeY = Math.floorMod(y + j[k], matrixDim);

			if (matrix[oppositeX][oppositeY] == fullSqr) {
				count += 1;
			}
		}
		return count;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);

		String[][] matrix = new String[matrixDim][matrixDim];
		for (int i = 0; i < matrixDim; i++) {
			for (int j = 0; j < matrixDim; j++) {
				matrix[i][j] = emptySqr;
			}
		}
		System.out.println("Created matrix " + matrixDim + "x" + matrixDim);

		Set<Pair> fullSqrsCoordinates = new HashSet<>();

		System.out.print("Number of full squares: ");
		int number = scanner.nextInt();
		System.out.println("Enter full square coordinates :");
		for (int i = 0; i < number; i++) {
			System.out.println("Square number(" + (i + 1) + "): ");

			System.out.print("X:");
			int x = scanner.nextInt();
			System.out.print("Y:");
			int y = scanner.nextInt();

			Pair pair = new Pair(x, y);
			fullSqrsCoordinates.add(pair);

			matrix[x][y] = fullSqr;
		}

		Set<Pair> toBeKilled = new HashSet<>();
		Set<Pair> toBeRevived = new HashSet<>();

		while (true) {
			printMatrix(matrix);
			toBeKilled.clear();
			toBeRevived.clear();
			for (int i = 0; i < matrixDim; i++) {
				for (int j = 0; j < matrixDim; j++) {
					int count = aliveNeighboursCount(i, j, matrix);
					if (isCellAlive(i, j, matrix)) {
						if (count < 2) {
							toBeKilled.add(new Pair(i, j));
						} else if (count == 2 || count == 3) {
							continue;
						} else if (count > 3) {
							toBeKilled.add(new Pair(i, j));
						}
					} else {
						if (count == 3) {
							toBeRevived.add(new Pair(i, j));
						}
					}

				}
			}

			for (Pair kill : toBeKilled) {
				killSqr(kill.getX(), kill.getY(), matrix);
			}
			for (Pair revive : toBeRevived) {
				reviveSqr(revive.getX(), revive.getY(), matrix);
			}

			Thread.sleep(500);
		}
	}
}
