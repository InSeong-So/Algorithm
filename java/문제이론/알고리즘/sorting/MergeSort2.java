public class MergeSort2 {

	private static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, temp, start, mid);
			mergeSort(arr, temp, mid + 1, end);
			merge(arr, temp, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (temp[part1] <= temp[part2]) {
				arr[index] = temp[part1];
				part1++;
			} else {
				arr[index] = temp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = temp[part1 + i];
		}
	}

	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 3, 9, 4, 7, 5, 0, 1, 6, 8, 2 };
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}

}
