import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParallelSort {
	public static void main(String[] args) {

		// Create a list and populate it with random numbers
		List<Integer> list = new ArrayList();
		Random r = new Random();
		for (int x = 0; x < 30000000; x++) {
			list.add(r.nextInt(10000));
		}

		// Create two arrays for sorting.
		Integer[] array1 = new Integer[list.size()];
		Integer[] array2 = new Integer[list.size()];
		array1 = list.toArray(array1);
		array2 = list.toArray(array2);

		// sort array
		long start = System.currentTimeMillis();
		Arrays.sort(array1);
		long end = System.currentTimeMillis();
		System.out.println("Sort Time: " + (end - start));

		// sort array using parallel sort
		start = System.currentTimeMillis();
		Arrays.parallelSort(array2);
		end = System.currentTimeMillis();
		System.out.println("Parallel Sort Time: " + (end - start));
	}
}
