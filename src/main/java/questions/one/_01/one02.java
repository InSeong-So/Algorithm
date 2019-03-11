package questions.one._01;

import java.util.Arrays;

/*
 * - 1.2 순열 확인
 * - 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드를 작성하라.
 */
public class one02 {

	// solution 1. 정렬하라.
	// solution 1-0.
	private String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	// solution 1-1.
	boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}

	/************************************************************************/

	// solution 2. 문자열에 포함된 문자의 출현 횟수가 같은지 검사하라.
	boolean permutation2(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] letters = new int[128];	// 가정

		char[] s_array = s.toCharArray();

		for (char c : s_array) {	// s 내에서 각 문자의 출현 횟수 카운트
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0)
				return false;
		}

		return true;
	}
}
