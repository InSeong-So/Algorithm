package algorithm.lsh;

import java.util.ArrayList;
import java.util.List;

import algorithm.custom.CustomList;
// 재귀 함수는 리턴 값이 반드시 있어야함
public class test {
	// 반을 나눠서 차례차례 정렬
	public static void main(String[] args) {
		List<Integer> n = CustomList.randomIntList(); 
		System.out.println(quickSort(n).toString());
	}
	public static List<Integer> quickSort(List<Integer> n){
		if(n.size() < 2)
			return n;
		
		int pivot = n.get(0); // 기준을 가장 빠른 값을 지정
		// pivot 보다 낮은값
		List<Integer> lower = new ArrayList<Integer>();
		// pivot 보다 높은값
		List<Integer> higher = new ArrayList<Integer>();
		// i 는 n[0] 이 pivot 으로 정해져 있음으로 1부터
		for(int i =1; i  < n.size(); i++) {
			if(n.get(i) <pivot)
				lower.add(n.get(i)); // add 는 값을 무조건 뒤에 붙인다
			else
				higher.add(n.get(i));
		}
		
		
		// lower 리스트가 정렬이 될때 까지 분할해서 값을 추가한다. 재귀 함수 자기 자신을 실행
		List<Integer> result = quickSort(lower);
		
		result.add(pivot); // higher 는 pivot 보다 크고 lower 는 작음으로 그 중간에 add 로 원소하나만을 집어넣어 pivot 의 위치를 정해준다
		
		//List<Integer> result = quickSort(higher); => 틀림x
		result.addAll(quickSort(higher)); // 맞는 표현
		// higher 리스트가 정렬이 될 때까지 분할해서 값을 추가한다.
		return result;
	} 
}
