public class QuickSort2 {

	public static int[] quickSort(int[] numbers, int left, int right) {
		if (numbers == null)
			return null;

		int[] sorted = numbers;

		if (left >= right)
			return sorted;

		int pivot = divideAndConquer(sorted, left, right);

		sorted = quickSort(sorted, left, pivot - 1);
		sorted = quickSort(sorted, pivot + 1, right);

		return sorted;
	}

	private static int divideAndConquer(int[] sorted, int left, int right) {
		if (sorted == null || left < 0)
			return -1;

		int pivot = sorted[right];
		int end = left - 1;

		int temp;
		for (int i = left; i < right; i++) {
			if (pivot > sorted[i]) {
				end += 1;
				temp = sorted[i];
				sorted[i] = sorted[end];
				sorted[end] = temp;
			}
		}

		end += 1;
		temp = sorted[right];
		sorted[right] = sorted[end];
		sorted[end] = temp;

		return end;
	}
}
