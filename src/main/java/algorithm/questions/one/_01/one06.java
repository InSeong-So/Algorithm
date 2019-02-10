package algorithm.questions.one._01;

/*
 * - 1.6 문자열 압축
 * - 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
 * - 예를 들어 문자열 aabccccaaa를 압축하면 a2b1c5a3이 된다.
 * - 만약 "압축된" 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다.
 * - 문자열은 대소문자 알파벳(a~z)으로만 이루어져 있다.
 */
public class one06 {

	// solution 1. Time Complexity O(n^2)
	String compressBad(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			// 다음 문자와 현재 문자가 같지 않다면 현재 문자를 결과 문자열에 추가해준다.
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}

	/************************************************************************/

	// solution 2.
	String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			// 다음 문자와 현재 문자가 같지 않다면 현재 문자를 결과 문자열에 추가한다.
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}

		return compressed.length() < str.length() ? compressed.toString() : str;
	}

	/************************************************************************/

	String compress2(String str) {
		// 압축된 문자열의 길이가 입력 문자열보다 길다면 입력 문자열을 반환한다.
		int finalLength = countCompression(str);
		if (finalLength >= str.length())
			return str;

		StringBuilder compressed = new StringBuilder(finalLength); // 처음 크기
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			// 다음 문자와 현재 문자가 같지 않다면 현재 문자를 결과 문자열에 추가한다.
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	private int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			// 다음 문자와 현재 문자가 같지 않다면 길이를 증가시킨다.
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}

		return compressedLength;
	}
}
