package dataStructure.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import searchAlgorithm.binarySearch.BinarySearch1;
import sortingAlgorithm.quickSort.QuickSortTest;

public class SearchTest {

	@Test
	public void binarySearchTest() {
		BinarySearch1 binarySearch1 = new BinarySearch1();

		assertEquals(true, binarySearch1.binarySearch(QuickSortTest.sortingList, 3));

	}
}
