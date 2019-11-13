package sortingAlgorithm.others;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("John");
		list.add("Ringo");
		list.add("George");
		list.add("Paul");

		for (String str : list) {
			System.out.println("Before: " + str);
		}

		Collections.sort(list);

		for (String str : list) {
			System.out.println("After: " + str);
		}

	}
}
