package mekici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MekiciSolver {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			int requests = scanner.nextInt();

			for (int i = 0; i < requests; i++) {
				System.out.println(solve(scanner));
			}
		}
	}

	private static int solve(Scanner scanner) {

		int mekiciCount = scanner.nextInt();
		int kotloniCount = scanner.nextInt();

		ArrayList<Integer> kotloni = new ArrayList<>();
		for (int i = 0; i < kotloniCount; i++) {
			kotloni.add(scanner.nextInt());
		}
		int minimumTime = calculateMinimumTime(mekiciCount, kotloniCount, kotloni);

		return minimumTime;
	}

	private static int calculateMinimumTime(int mekiciCount, int kotloniCount, ArrayList<Integer> kotloni) {
		int low = 0;
		int high = Collections.min(kotloni) * mekiciCount;

		while (low < high) {
			int mid = (low + ((high - low) / 2));

			if (canCookMekici(mekiciCount, kotloniCount, kotloni, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static boolean canCookMekici(int mekiciCount, int kotloniCount, ArrayList<Integer> kotloni,
			int targetTime) {

		int cookedMekici = 0;
		for (Integer kotlon : kotloni) {
			cookedMekici += targetTime / kotlon;
		}

		return cookedMekici >= mekiciCount;
	}
}
