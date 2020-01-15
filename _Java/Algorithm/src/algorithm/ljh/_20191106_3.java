package algorithm.ljh;

import java.util.ArrayList;
import java.util.List;

import algorithm.custom.CustomList;

public class _20191106_3 {

	public static void main(String[] args) {
		List<Integer> n = CustomList.randomIntList(100, 20);
		System.out.println(n.toString());
		
		List<Integer> m = quickSort(n);
		System.out.println(m.toString());
		
	}
	
	
	public static List<Integer> quickSort(List<Integer> n){
		
		if(n.size() < 2) {
			return n;
		}
		int pivot = n.get(0);
		// pivot보다 작은값
		List<Integer> lower = new ArrayList<Integer>();
		// pivot보다 큰값
		List<Integer> higher = new ArrayList<Integer>();
		
		for(int i=1;i<n.size();i++) {
			if(n.get(i) < pivot) {
				lower.add(n.get(i));
			} else {
				higher.add(n.get(i));
			}
		}
		// lower 리스트가 정렬이 될때까지 분할해서 값을 추가한다.
		List<Integer> result = quickSort(lower);
		// higher 리스트가 정렬이 될 때까지 분할해서 값을 추가한다.
		result.add(pivot);
		result.addAll(quickSort(higher));
		
		return result;
	}

}
