package algorithm.codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = { 9, 3, 9, 3, 9, 7, 9 };

		// int temp = 0;
		//
		// for (int i = 0; i < A.length; i++) {
		// temp = temp ^ A[i];
		// System.out.println(temp);
		// }
		// System.out.println(temp);

		Set<Integer> hs = new HashSet<Integer>();

		for (int a : A) {
			if (hs.contains(a)) {
				hs.remove(a);
			} else {
				hs.add(a);
			}
		}
		System.out.println(hs.iterator().next());
	}
}
