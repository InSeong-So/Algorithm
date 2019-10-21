package dataStructure.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		System.out.println(list);
		
		list.add(1, 50);
		
		System.out.println(list);
		
		list.remove(2);
		
		System.out.println(list);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			int value = (int) it.next();
			System.out.println("Iterator : " + value);
		}
		
		for(int value : list) {
			System.out.println(value);
		}
		
//		hasNext = 가져올 수 있는 다음 엘리먼트가 있느냐, boolean 타입 반환
//		next = 값을 반환
	}
}
