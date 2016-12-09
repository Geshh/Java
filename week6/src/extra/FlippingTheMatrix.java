package extra;

import java.util.Scanner;

public class FlippingTheMatrix {

	public static int upperLeftQuadrantSum(int[][] matrix) {
		int sum = 0;

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				sum += matrix[i][j];
			}
		}

		return sum;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int q = scanner.nextInt();

		for (int k = 0; k < q; k++) {

			int n = scanner.nextInt();

			int[][] matrix = new int[2 * n][2 * n];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}

			int lastIndex = matrix.length - 1;
			for (int i = 0; i < matrix.length / 2; i++) {
				for (int j = 0; j < matrix.length / 2; j++) {
					matrix[i][j] = Math.max(Math.max(matrix[i][j], matrix[lastIndex - i][lastIndex - j]),
							Math.max(matrix[i][lastIndex - j], matrix[lastIndex - i][j]));
				}
			}

			System.out.println(upperLeftQuadrantSum(matrix));
		}

		scanner.close();
	}
}
