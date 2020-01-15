package algorithm.ljh;

public class _20191023_1 {

	public static void main(String[] args) {

		String inputString = "abcdefghijklmnopqrstuvwxyz";

		if (isUniqueChars(inputString)) {
			System.out.println("같은 문자가 없습니다.");
		} else {
			System.out.println("같은 문자가 존재합니다.");
		}

	}

	static boolean isUniqueChars(String str) {
// 코드 작성
//for, if
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
