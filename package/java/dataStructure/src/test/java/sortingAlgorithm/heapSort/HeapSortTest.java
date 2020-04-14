package sortingAlgorithm.heapSort;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HeapSortTest {
	int[] numbers = { 4, 7, 1, 6, 3, 5, 4 };
	int[] afterSorting = { 1, 3, 4, 4, 5, 6, 7 };
	public static List<Integer> numbersList = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
	public static List<Integer> sortingList = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
	
	@Test
	public void heapSortTest() {

		System.out.print("정렬 전 : ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

		HeapSort.heapSort(numbers, numbers.length);

		for (int i = numbers.length - 1; i > 0; i--) {
			int temp = numbers[0];
			numbers[0] = numbers[i];
			numbers[i] = temp;

			HeapSort.heapSort(numbers, i);
		}

		System.out.print("\n정렬 후 : ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}
}
