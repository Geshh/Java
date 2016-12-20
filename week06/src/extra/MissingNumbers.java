package extra;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbers {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int sizeOne = scanner.nextInt();
		int[] arrOne = new int[sizeOne];

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < sizeOne; i++) {
			arrOne[i] = scanner.nextInt();
			if (arrOne[i] > max) {
				max = arrOne[i];
			}
			if (arrOne[i] < min) {
				min = arrOne[i];
			}
		}

		int sizeTwo = scanner.nextInt();
		int[] arrTwo = new int[sizeTwo];

		for (int i = 0; i < sizeTwo; i++) {
			arrTwo[i] = scanner.nextInt();
			if (arrTwo[i] > max) {
				max = arrTwo[i];
			}
			if (arrTwo[i] < min) {
				min = arrTwo[i];
			}
		}

		int[] histOne = new int[max - min + 1];
		int[] histTwo = new int[max - min + 1];

		for (int i = 0; i < arrOne.length; i++) {
			histOne[max - arrOne[i]] += 1;
		}
		for (int i = 0; i < arrTwo.length; i++) {
			histTwo[max - arrTwo[i]] += 1;
		}

		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < histOne.length; i++) {
			if (histOne[i] != histTwo[i]) {
				set.add(max - i);
			}
		}
		
		for(Integer i : set) {
			System.out.print(i + " ");
		}

		scanner.close();
	}
}
