import java.util.Arrays;

public class CocktailSort {

	/* 칵테일 정렬은 버블 정렬의 개선입니다.
	 * 개선방법은 기본적으로 값이 배열을 통해 양방향으로 "버블"된다는 것입니다.
	 * 각 반복에서 칵테일 정렬 버블은 한 번 전진하고 한 번 뒤로 정렬하기 때문입니다.
	 * 칵테일 정렬은 셰이커 정렬 또는 칵테일 셰이커 정렬로 알려져 있습니다.*/
	public static void sort(int[] array) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i <= array.length - 2; i++) {
				if (array[i] > array[i + 1]) {
					// test whether the two elements are in the wrong order
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				// we can exit the outer loop here if no swaps occurred.
				break;
			}
			swapped = false;
			for (int i = array.length - 2; i >= 0; i--) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
			// if no elements have been swapped, then the list is sorted
		} while (swapped);
	}

	public static void main(String[] args) {

		int[] array = { 5, 3, 0, 2, 4, 1, 0, 7, 2, 9, 1, 4 };
		System.out.println("Before: " + Arrays.toString(array));
		sort(array);
		System.out.println("After:  " + Arrays.toString(array));

	}
}
