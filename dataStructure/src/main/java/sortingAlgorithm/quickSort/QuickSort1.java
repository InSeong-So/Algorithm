package sortingAlgorithm.quickSort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort1 {

	// 퀵 정렬 알고리즘
	public static List<Integer> quickSort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}

		Integer pivot = numbers.get(0);
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();

		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}

		List<Integer> sorted = quickSort(lower);
		sorted.add(pivot);
		sorted.addAll(quickSort(higher));

		return sorted;
	}
}
