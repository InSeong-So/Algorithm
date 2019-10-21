package sortingAlgorithm.mergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort1 {

	// 병합 정렬 알고리즘
	public static int[] mergeSort(int[] numbers) {
		if (numbers.length < 2) {
			return numbers;
		}

		int[] leftArray = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
		int[] rightArray = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
		return merge(mergeSort(leftArray), mergeSort(rightArray));
	}

	// 병합
	private static int[] merge(int[] left, int[] right) {
		int leftPtr = 0;
		int rightPtr = 0;
		int index = 0;

		int[] merged = new int[left.length + right.length];

		while (leftPtr < left.length && rightPtr < right.length) {
			if (left[leftPtr] < right[rightPtr]) {
				merged[index] = left[leftPtr];
				leftPtr++;
				index++;
			} else {
				merged[index] = right[rightPtr];
				rightPtr++;
				index++;
			}
		}

		while (leftPtr < left.length) {
			merged[index] = left[leftPtr];
			leftPtr++;
			index++;
		}

		while (rightPtr < right.length) {
			merged[index] = right[rightPtr];
			rightPtr++;
			index++;
		}

		return merged;
	}

	/***************************************************************************/

	// 병합 정렬 알고리즘
	public static List<Integer> mergeSort(List<Integer> values) {
		if (values.size() < 2) {
			return values;
		}

		List<Integer> leftHalf = values.subList(0, values.size() / 2);
		List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
		return merge(mergeSort(leftHalf), mergeSort(rightHalf));
	}

	// 병합
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		int leftPtr = 0;
		int rightPtr = 0;

		List<Integer> merged = new ArrayList<>(left.size() + right.size());

		while (leftPtr < left.size() && rightPtr < right.size()) {
			if (left.get(leftPtr) < right.get(rightPtr)) {
				merged.add(left.get(leftPtr));
				leftPtr++;
			} else {
				merged.add(right.get(rightPtr));
				rightPtr++;
			}
		}

		while (leftPtr < left.size()) {
			merged.add(left.get(leftPtr));
			leftPtr++;
		}

		while (rightPtr < right.size()) {
			merged.add(right.get(rightPtr));
			rightPtr++;
		}

		return merged;
	}

}
