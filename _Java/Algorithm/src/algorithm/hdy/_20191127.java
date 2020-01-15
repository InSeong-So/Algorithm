package algorithm.hdy;

import java.util.Arrays;

public class _20191127 {
	// Merge Sort
	
	public static void main(String[] args) {
		int[] numbers = {5, 3, 2, 7, 12, 52, 31, 1};
		
		numbers = mergeSort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
	
	private static int[] mergeSort(int[] numbers) {
		
		if(numbers.length <2) {
			return numbers;
		}
		int[] leftArray = Arrays.copyOfRange(numbers, 0, numbers.length/2);
		int[] rightArray = Arrays.copyOfRange(numbers, numbers.length/2, numbers.length);
		
		return merge(mergeSort(leftArray), mergeSort(rightArray));
	}
	
	private static int[] merge(int[] leftArray, int[] rightArray) {
		
		int leftPtr, rightPtr, index;
		leftPtr = rightPtr = index = 0;
		
		int[] merged = new int[leftArray.length + rightArray.length];
		
		while(leftPtr < leftArray.length && rightPtr < rightArray.length) {
			if(leftArray[leftPtr] < rightArray[rightPtr]) {
				merged[index] = leftArray[leftPtr];
				index++;
				leftPtr++;
			}else {
				merged[index] = rightArray[rightPtr];
				index++;
				rightPtr++;
			}
		}
		
		while(leftPtr < leftArray.length) {
			merged[index] = leftArray[leftPtr];
			index++;
			leftPtr++;
		}
		
		while(rightPtr < rightArray.length) {
			merged[index] = rightArray[rightPtr];
			index++;
			rightPtr++;
		}
		
		return merged;
	}
	
	
}
