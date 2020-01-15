package algorithm.hdy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.custom.CustomList;

public class _20191106 {

	public static void main(String[] args) {

		CustomList cl = new CustomList();

		// 중복 없는 랜덤 난수 배열 생성
		int[] n = cl.randomIntArray(100, 20);
		System.out.println("중복 없는 랜덤 난수 배열 출력 :");
		System.out.println(Arrays.toString(n));
		
		System.out.println("버블");
		System.out.println(Arrays.toString(bubbleSort(n)));
		
		System.out.println("선택");
		System.out.println(Arrays.toString(selectSort(n)));
		
		List<Integer> list =  cl.randomIntList(100, 20);
		System.out.println("퀵");
		System.out.println(quickSort(list).toString());

	}

	// 스왑 메소드 어떻게 구현.. ?
	public static void swap() {

	}

	// 버블 정렬
	public static int[] bubbleSort(int[] list) {

		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[i]) { // j 가 뒤
					int temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
		return list;
	}

	// 선택 정렬
	public static int[] selectSort(int[] list) {
		 
		int maxIndex= list.length-1;
		
		for (int i = list.length-1; i <=0; i--) {
			for (int j = i; j >= 0; j--) {
				if (list[maxIndex] < list[j]) {
					maxIndex = j;
				}
			}
			
			int temp = list[i];
			list[i] = list[maxIndex];
			list[maxIndex] = temp;	
		}
		 
		return list;
	}

	// 삽입 정렬
	public static void insertSort(int[] list) {
		
	}
	
	// 퀵 정렬
	public static List<Integer> quickSort(List<Integer> list) {
		
		if(list.size() <2) {
			return list;
		}
		//43
		int pivot = list.get(0);
		
		List<Integer> larger = new ArrayList<Integer>();
		List<Integer> smaller = new ArrayList<Integer>();
		
		for (int i = 1; i < list.size(); i++) {
			
			if(list.get(i) > pivot) {
				larger.add(list.get(i));
			}else {
				smaller.add(list.get(i));
			}
			
		}
		
		System.out.println("작은 값 리스트 : " + smaller.toString());
		System.out.println("기준 값"+pivot);
		System.out.println("큰 값 리스트" + larger.toString());
		// 18, 19
		// 43, 75
		List<Integer> result = quickSort(smaller); // 18 19
		result.add(pivot); // 27
		result.addAll(quickSort(larger)); // 43 75
		
		return result;
	}

}
