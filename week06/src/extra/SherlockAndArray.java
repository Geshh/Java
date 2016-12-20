package extra;

import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int caseNum = scanner.nextInt();

		for (int k = 0; k < caseNum; k++) {

			int size = scanner.nextInt();
			int[] arr = new int[size];

			for (int i = 0; i < size; i++) {
				arr[i] = scanner.nextInt();
			}

			int[] arrLeft = new int[size];
			int[] arrRight = new int[size];

			for (int i = 1; i < size; i++) {
				arrLeft[i] = arr[i - 1] + arrLeft[i - 1];
			}
			for (int i = size - 2; i >= 0; i--) {
				arrRight[i] = arr[i + 1] + arrRight[i + 1];
			}

			boolean isTrue = false;
			for (int i = 0; i < size; i++) {
				if (arrRight[i] == arrLeft[i]) {
					isTrue = true;
				}
			}

			if (isTrue) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}
}
