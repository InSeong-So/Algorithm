package algorithm.yjh;

import java.util.ArrayList;
import java.util.List;

import algorithm.custom.CustomList;

public class test {

	public static void main(String[] args) {
		List<Integer> n = CustomList.randomIntList();
		System.out.println(quickSort(n).toString());
	}
	
	public static List<Integer> quickSort(List<Integer> n) {
		
		// 예외
		if(n.size() < 2) {
			return n;
		}
		
		int pivot = n.get(0); // 기준점 : 최저값
		
		List<Integer> lower = new ArrayList<Integer>(); // pivot보다 낮은 값
		
		List<Integer> higher = new ArrayList<Integer>(); // pivot보다 큰 값
		
		for(int i = 1; i < n.size(); i++) {
			if(n.get(i) < pivot) {
				lower.add(n.get(i)); // add는 무조건 뒤에 붙임
			} else {
				higher.add(n.get(i));
			}
		}
		
		// lower리스트가 정렬 될 떄까지 분할해서 값을 추가
		List<Integer> result = quickSort(lower); // 재귀
		
		// pivot값 (중간값) 추가
		result.add(pivot);
		
		// higher 리스트가 정렬이 될 때까지 분할해서 값을 추가
		result.addAll(quickSort(higher)); // addAll(Collection) 리스트 전체 추가
		
		
		return result;
	}
}



