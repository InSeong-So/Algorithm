public class HeapSort {

	public static void heapSort(int[] numbers, int size) {
		for (int i = 1; i < size; i++) {
			int child = i;
			while (child > 0) {
				int parent = (child - 1) / 2;
				if (numbers[child] > numbers[parent]) {
					int temp = numbers[parent];
					numbers[parent] = numbers[child];
					numbers[child] = temp;
				}
				child = parent;
			}
		}
	}

}
