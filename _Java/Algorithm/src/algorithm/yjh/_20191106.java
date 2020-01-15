package algorithm.yjh;

import java.util.Arrays;

import algorithm.custom.CustomList;

public class _20191106 {
	public static void main(String[] args) {
		int[] input = CustomList.randomIntArray();
		bubbleSort(input);
        System.out.println("정렬 o 배열 : " + Arrays.toString(input));
        System.out.println(">> 버블 정렬 종료!");
        
        input = CustomList.randomIntArray();
        System.out.println("# 선택 정렬 시작!");
        System.out.println("정렬 x 배열 : " + Arrays.toString(input));
        selectionSort(input);
        System.out.println("정렬 o 배열 : " + Arrays.toString(input));
        System.out.println(">> 선택 정렬 종료!");
    }
	
	static void bubbleSort(int[] n) {
		System.out.println("버블정렬");
		int temp = 0;
		for(int i = 0; i < n.length; i++) {
			for(int j = i + 1; j < n.length; j++) {
				if(n[i] > n[j]) {
					temp = n[j];
					n[j] = n[i];
					n[i] = temp;
				}
			}
		}
	}
	
	static void insertionSort(int[] n) {
		System.out.println("삽입정렬");
		int temp = 0;
		for(int i = 0; i < n.length; i++) {
			
		}
	}
	
	static void selectionSort(int[] n) {
		System.out.println("선택정렬");
		// 루프의 최대 원소를 찾는다. v
		// 최대 원소와 맨 오른쪽 원소를 교환한다.
		// 맨 오른쪽 원소를 제외한다.
		int temp = 0;
		int maxNum = 0;
		for(int i = 0; i < n.length; i++) {
			if(maxNum < n[i]) {
				maxNum = n[i];
			}
		}
		for(int j = n.length - 1; j >= 0; j--) {
			// 값 저장
			// i를 가져와서 바꿈
			// 큰값 바꿈
			n[j] = maxNum;
			
		}
		
		
		System.out.println("최대값 : " + maxNum);
	}
}
	




