package sortingAlgorithm.countingSort;

import java.util.Arrays;

public class CountingSort {

	/* 카운팅 정렬은 특정 범위 사이의 키를 기반으로하는 정렬 기법입니다.
	 * 별개의 키 값 (해싱의 종류)을 가진 객체의 수를 계산함으로써 작동합니다.
	 * 그런 다음 출력 시퀀스에서 각 객체의 위치를 ​​계산하기 위해 일부 산술 연산을 수행합니다.*/

	public static int[] sort(int[] array) {

		// array to be sorted in, this array is necessary
		// when we sort object datatypes, if we don't,
		// we can sort directly into the input array
		int[] aux = new int[array.length];

		// find the smallest and the largest value
		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			} else if (array[i] > max) {
				max = array[i];
			}
		}

		// init array of frequencies
		int[] counts = new int[max - min + 1];

		// init the frequencies
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;
		}

		// recalculate the array - create the array of occurences
		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
		}

		/*
		  Sort the array right to the left
		  1) Look up in the array of occurences the last occurence of the given value
		  2) Place it into the sorted array
		  3) Decrement the index of the last occurence of the given value
		  4) Continue with the previous value of the input array (goto set1), 
		     terminate if all values were already sorted
		*/
		for (int i = array.length - 1; i >= 0; i--) {
			aux[counts[array[i] - min]--] = array[i];
		}

		return aux;
	}

	public static void main(String[] args) {

		int[] unsorted = { 5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4 };
		System.out.println("Before: " + Arrays.toString(unsorted));

		int[] sorted = sort(unsorted);
		System.out.println("After:  " + Arrays.toString(sorted));

	}
}
