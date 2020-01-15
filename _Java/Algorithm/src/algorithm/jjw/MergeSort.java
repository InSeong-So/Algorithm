package algorithm.jjw;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String[] args) {
		
		int[] numbers = {5,3,2,7,12,52,31,1};

	
		System.out.println(Arrays.toString(mergeSort(numbers)));
	}
	
	public static int[] mergeSort(int[] numbers) {
		
		
		// 정렬하는 배열의 원소가 아니라면 배열 그래도 리턴 : 재귀호출의 종료 조건
		if (numbers.length < 2) {
			return numbers;
		}
		
		// 분할한 원소들을 담을 배열, 0부터 절반까지 (원소의 갯수가 홀수의 경우 소수점 절삭)
		int[] leftArray = Arrays.copyOfRange(numbers,0,numbers.length/2);
		// 분할한 원소들을 담을 배열, 절반까지 끌까지
		int[] rightArray = Arrays.copyOfRange(numbers,numbers.length/2,numbers.length);
		
		return merge(mergeSort(leftArray),mergeSort(rightArray));
	}

	private static int[] merge(int[] leftArray, int[] rightArray) {
		
		// 왼쪽 배열의 순서를 저장하는 포인터
		int leftPointer = 0;
		// 오른쪽 배열의 순서를 저장하는 포인터
		int rightPointer = 0;
		// 병합할 배열에 값을 저장할 위치를 나타내는 변수
		int index = 0;
		
		// 왼쪽 배열과 오른쪽 배열을 병합할 배열 생성
		int[] merged = new int[leftArray.length + rightArray.length];
		
		
		// 왼쪽 배열의 포인터가 왼쪽 배열의 크기보다 커지거나 
		// 오른쪽 배열의 포인터가 오른쪽 배열의 크기보다 커지면 반복문 종료
		while(leftPointer < leftArray.length && rightPointer < rightArray.length) {

			if(leftArray[leftPointer] < rightArray[rightPointer]) {
				merged[index] = leftArray[leftPointer];
				leftPointer ++;
				index ++;
			} else {
				merged[index] = rightArray[rightPointer];
				rightPointer ++;
				index ++;
			}
		}
		while(leftPointer < leftArray.length) {
			merged[index] = leftArray[leftPointer];
			leftPointer ++;
			index ++;
		}
		
		while(rightPointer < rightArray.length) {
			merged[index] = rightArray[rightPointer];
			rightPointer ++;
			index ++;
		}
		
		return merged;
	}
	
}
