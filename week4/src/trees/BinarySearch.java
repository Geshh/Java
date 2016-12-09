package trees;

public class BinarySearch {

	public static int binSearch(int[] arr, int target, int left, int right) {
		int mid = (left + right) / 2;
		if (left > right) {
			return -1;
		} else {
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				return binSearch(arr, target, left, mid - 1);
			} else {
				return binSearch(arr, target, mid + 1, right);
			}
		}
	}

	// 1 2 5 8 `11 20
	public static int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		int result = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				result = mid;
				break;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
	public static int interpolarSearch() {
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 8, 11, 20 };
		System.out.println(binSearch(arr, 1, 0, arr.length - 1));
	}
}
