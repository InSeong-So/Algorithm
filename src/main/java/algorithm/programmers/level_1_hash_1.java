package algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

public class level_1_hash_1 {

	public String solution(String[] participant, String[] completion) {
		// 처음 시도했던 방법
		// String answer = "";
		// Arrays.sort(participant);
		// Arrays.sort(completion);
		// for (int i = 0; i < completion.length; i++) {
		// if (!completion[i].equals(participant[i])) {
		// answer = participant[i];
		// } else {
		// answer = participant[i + 1];
		// }
		// }
		// return answer;

		// 두번째 시도했던 방법
		String answer = "";
		int count = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String str : participant) {
			if (map.get(str) == null) {
				map.put(str, 1);
			} else {
				count = map.get(str) + 1;
				map.put(str, count);
			}
		}
		for (String str : completion) {
			count = map.get(str) - 1;
			map.put(str, count);
		}

		for (String str : participant) {
			if (map.get(str) != 0) {
				answer = str;
			}
		}

		return answer;
	}
}
