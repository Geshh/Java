package sortingAlgs;

public class MyMain {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 4, 8, 7, 6, 4, 0 };
		
		Sort.countingSort(arr);
		
//		for(int i=0;i<arr.length;i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		int[] other = { 1, 2, 9, 5, 59, 87, 12, 45, 65, 2, 14, 56, 84, 23, 54, 45, 89, 59, 2, 6, -6 };
		
		Sort.mergeSort(other);
		
		for(int i=0;i<other.length;i++) {
			System.out.print(other[i] + " ");
		}
		
	}
}
