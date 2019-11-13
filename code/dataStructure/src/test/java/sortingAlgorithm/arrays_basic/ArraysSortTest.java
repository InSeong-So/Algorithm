package sortingAlgorithm.arrays_basic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysSortTest {

//	@Test
	public void sortInts() {
		int[] beforeSorting = { 5, 28, 3, 199, 200, 31, 4 };
		int[] afterSorting = { 3, 4, 5, 28, 31, 199, 200 };

		Arrays.sort(beforeSorting);
		assertArrayEquals(afterSorting, beforeSorting);
	}

//	@Test
	public void sortStrings() {
		String[] beforeSorting = { "z", "x", "y", "abc", "zzz", "zazzy" };
		String[] afterSorting = { "abc", "x", "y", "z", "zazzy", "zzz" };

		Arrays.sort(beforeSorting);
		assertArrayEquals(afterSorting, beforeSorting);

	}

//	@Test
	public void customSorting() {
		List<Integer> beforeSorting = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		List<Integer> afterSorting = Arrays.asList(7, 6, 5, 4, 4, 3, 1); // 역순서 정렬 테스트
		List<Integer> afterSorting2 = Arrays.asList(1, 3, 4, 4, 5, 6, 7); // 순서 정렬 테스트

		Collections.sort(beforeSorting, new ArraysSort());
		System.out.println(beforeSorting);
		assertEquals(afterSorting, beforeSorting);
		assertEquals(afterSorting2, beforeSorting);
	}
}
