package algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class level_1_absoluteSearch_1 {

	public static void main(String[] args) {
		// int[] test = { 1, 2, 3, 4, 5 };
		// int[] test = { 1, 3, 2, 4, 2 };
		int[] test = { 3, 3, 1, 1, 2 };

		List<int[]> list = new ArrayList<int[]>();

		int[] val1 = { 1, 2, 3, 4, 5 };
		int[] val2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] val3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		list.add(val1);
		list.add(val2);
		list.add(val3);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.size(); i++) {
			int start = 0;
			int count = 0;
			for (int k = start; k < list.get(0).length; k++) {
				if (k > 0 && k % 5 == 0) {
					start = 0;
				}
				if (list.get(i)[k] == test[start]) {
					count++;
				}
				start++;
			}
			if (count != 0) {
				map.put(i + 1, count);
			}
		}

		int[] answer = new int[map.size()];

		int index = 0;

		Set<Integer> set1 = map.keySet();
		for (Iterator it = set1.iterator(); it.hasNext();) {
			if (map.get((int) it.next()) < map.get((int) it.next()))
				answer[index] = (int) it.next();
			index++;
		}
	}
}
