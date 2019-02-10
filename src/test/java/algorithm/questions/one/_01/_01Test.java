package algorithm.questions.one._01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _01Test {

	@Test
	void one01() {
		String str = "thdlstjd";
		one01 test = new one01();
		// assertEquals(false, test.isUniqueChars(str));
		assertEquals(false, test.isUniqueChars2(str));
	}

	@Test
	void one02() {
		String s = "asdofjo";
		String t = "ofodsaj";
		one02 test = new one02();
		assertEquals(true, test.permutation(s, t));
		// assertEquals(true, test.permutation2(s, t));
		// assertEquals(false, test.permutation(s, t));
	}

	@Test
	void one03() {
		String str = "My name is John";
		String check = "My%20name%20is%20John";
		char[] checkArray = check.toCharArray();
		one03 test = new one03();
		// for (int i = 0; i < test.replaceSpaces(str, str.length()).length; i++) {
		// System.out.println(test.replaceSpaces(str, str.length())[i]);
		// }
		// assertArrayEquals(new char[] {}, test.replaceSpaces(str, str.length() + 9));
		assertArrayEquals(checkArray, test.replaceSpaces(str, str.length()));
	}

	@Test
	void one04() {
		one04 test = new one04();
		String s = "tact coa";
		String t = "asodifjk";
		assertEquals(true, test.isPermutationOfPalindrome(s));
		assertEquals(false, test.isPermutationOfPalindrome2(t));
		assertEquals(false, !test.isPermutationOfPalindrome3(s));
	}

	@Test
	void one05() {
		String s = "pale";
		String d = "bale";
		one05 test = new one05();
		assertEquals(true, test.oneEditAway(s, d));
	}

	@Test
	void one06() {
		one06 test = new one06();
		// assertEquals("a2b1c4a3", test.compressBad("aabccccaaa"));
		// assertEquals("a2b1c4a3", test.compress("aabccccaaa"));
		assertEquals("a2b1c4a3", test.compress2("aabccccaaa"));
	}

	@Test
	void one07() {
		one07 test = new one07();
		int[][] matrix = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
		int[][] check = { { 4, 3, 2, 1 }, { 4, 3, 2, 1 }, { 4, 3, 2, 1 }, { 4, 3, 2, 1 } };

		test.rotate(matrix);
		assertArrayEquals(check, matrix);

		// for (int i = 0; i < matrix.length; i++) {
		// for (int j = 0; j < matrix[i].length; j++) {
		// System.out.print(matrix[i][j]);
		// }
		// System.out.println();
		// }
	}

	@Test
	void one08() {
		one08 test = new one08();
		int[][] matrix = { { 1, 1, 0, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 0, 4, 4 } };
		int[][] check = { { 0, 0, 0, 0 }, { 2, 0, 0, 2 }, { 3, 0, 0, 3 }, { 0, 0, 0, 0 } };

		test.setZeros(matrix);
		assertArrayEquals(check, matrix);

		// for (int i = 0; i < matrix.length; i++) {
		// for (int j = 0; j < matrix[i].length; j++) {
		// System.out.print(matrix[i][j]);
		// }
		// System.out.println();
		// }
	}

	@Test
	void one09() {
		String s = "waterbottle";
		String m = "erbottlewat";
		one09 test = new one09();
		assertEquals(true, test.isRotation(s, m));
	}
}
