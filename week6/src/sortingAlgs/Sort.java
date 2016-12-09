package sortingAlgs;

public class Sort {

	public static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 1; j < arr.length; j++) {

				if (arr[j] < arr[j - 1]) {

					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			for (int j = i; j > 0; j--) {

				if (arr[j] < arr[j - 1]) {

					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {

		int min;
		int copy;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			copy = arr[i];
			arr[i] = arr[min];
			arr[min] = copy;

		}
	}

	private static void merge(int[] arr, int[] left, int[] right) {

		int first;
		int second;

		for (first = 0, second = 0; first < left.length && second < right.length;) {
			if (left[first] < right[second]) {
				arr[first + second] = left[first];
				first += 1;
			} else {
				arr[first + second] = right[second];
				second += 1;
			}
		}

		if (first < left.length) {
			while (first < left.length) {
				arr[first + second] = left[first];
				first += 1;
			}
		} else if (second < right.length) {
			while (second < right.length) {
				arr[first + second] = right[second];
				second += 1;
			}
		}
	}

	public static void mergeSort(int[] arr) {
		if (arr.length <= 2) {
			bubbleSort(arr);
		} else {

			int leftSize;
			int rightSize;
			if (arr.length % 2 == 0) {
				leftSize = rightSize = arr.length / 2;
			} else {
				leftSize = arr.length / 2;
				rightSize = leftSize + 1;
			}

			int[] left = new int[leftSize];
			int[] right = new int[rightSize];

			for (int i = 0; i < leftSize; i++) {
				left[i] = arr[i];
			}
			for (int i = 0; i < rightSize; i++) {
				right[i] = arr[i + leftSize];
			}

			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}

	public static void quickSort(int[] arr) {
		
	}

	public static void countingSort(int[] arr) {

		// count range
		int histogramSize = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > histogramSize) {
				histogramSize = arr[i];
			}
		}

		int[] histArray = new int[histogramSize + 1];

		// fill histArray with arr

		for (int i = 0; i < arr.length; i++) {
			histArray[arr[i]] += 1;
		}

		// sort array
		int lastIndex = 0;
		for (int i = 0; i < histArray.length; i++) {
			if (histArray[i] != 0) {
				for (int j = 0; j < histArray[i]; j++) {
					arr[lastIndex++] = i;
				}
			}
		}
	}

}
