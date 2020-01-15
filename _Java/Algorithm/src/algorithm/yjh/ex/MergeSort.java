package algorithm.yjh.ex;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] numbers = {5, 3, 2, 7, 12, 52, 9};
		System.out.println(Arrays.toString(mergeSort(numbers)));
	}
	
	private static int[] mergeSort(int[] numbers) {
		
		if(numbers.length < 2) {
			return numbers;
		}
		
		int[] leftArray = Arrays.copyOfRange(numbers, 0, numbers.length/2 );
		int[] rightArray = Arrays.copyOfRange(numbers, numbers.length/2, numbers.length );
		
		
		return merge(mergeSort(leftArray), mergeSort(rightArray));
	}
	
	private static int[] merge(int[] leftArray, int[] rightArray) {
		
		// 왼쪽 배열의 순서를 저장하는 포인터
		int leftPtr = 0;
		
		// 오른쪽 배열의 순서를 저장하는 포인터
		int rightPtr = 0;
		
		// 병합할 배열에 값을 저장할 위치를 나타내는 변수
		int index = 0;
		
		// 왼쪽 배열과 오른쪽 배열을 병합할 배열 생성
		int[] merged = new int[leftArray.length + rightArray.length];
		
		while(leftPtr < leftArray.length && rightPtr < rightArray.length) {
			
			if(leftArray[leftPtr] < rightArray[rightPtr]) {
				
				merged[index] = leftArray[leftPtr];
				leftPtr++;
				index++;
			} else {
				merged[index] = rightArray[rightPtr];
				rightPtr++;
				index++;
			}
		}
		
		while(leftPtr < leftArray.length) {
			merged[index] = leftArray[leftPtr];
			leftPtr++;
			index++;
		}
		
		while(rightPtr < rightArray.length) {
			merged[index] = rightArray[rightPtr];
			rightPtr++;
			index++;
		}
		
		return merged;
	}
}




