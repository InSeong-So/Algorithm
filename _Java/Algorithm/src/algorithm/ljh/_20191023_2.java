package algorithm.ljh;

public class _20191023_2 {
	/*
	 * 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를 작성하라. 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이
	 * 이미 확보되어 있다. 문자열의 최종 길이가 함께 주어진다고 가정해도 된다. (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자
	 * 배열(character array)를 이용하길 바란다)
	 */
	public static void main(String[] args) {

		String str = " Hello world ";
		char[] array = replaceSpaces(str, 18);
		System.out.println(array);
		System.out.println(array.length);

	}

	static char[] replaceSpaces(String str, int trueLength) {
		char[] array = new char[19];
		// System.out.println(str +c+ trueLength);
		// 코드 작성
		// str에 있는 모든 공백 찾기 for(if) ' ' -> %20 를 array에 담아준다.
		// 뭐야 오른쪽으로 밀어야되나

		for (int i = 0, j = 0; i < trueLength; i++, j++) {

			if (' ' == str.charAt(j)) {
				array[i] = '%';
				array[i + 1] = '2';
				array[i + 2] = '0';
				i += 2;
			} else {
				array[i] = str.charAt(j);
			}
		}

		return array;
	}
}
