import java.util.Arrays;

public class CycleSort {

	public static void main(String[] args) {
		int[] arr = { 0, 2, 4, 6, 8, 10, 11, 9, 7, 5, 3, 1, 12, 13, 14 };

		System.out.println("Before: " + Arrays.toString(arr));
		int writes = cycleSort(arr);
		System.out.println("After: " + Arrays.toString(arr));

		System.out.println("Writes: " + writes);
	}

	static int cycleSort(int[] a) {
		int writes = 0;

		for (int cycleStart = 0; cycleStart < a.length - 1; cycleStart++) {
			int val = a[cycleStart];

			/*
			Count the number of values that are smaller 
			than val since cycleStart
			*/
			int pos = cycleStart;
			for (int i = cycleStart + 1; i < a.length; i++) {
				if (a[i] < val) {
					pos++;
				}
			}

			// there aren't any
			if (pos == cycleStart) {
				continue;
			}

			// Skip duplicates
			while (val == a[pos]) {
				pos++;
			}

			// Put val into final position
			int tmp = a[pos];
			a[pos] = val;
			val = tmp;
			writes++;

			/*
			Repeat as long as we can find values to swap
			otherwise start new cycle
			*/
			while (pos != cycleStart) {
				pos = cycleStart;
				for (int i = cycleStart + 1; i < a.length; i++) {
					if (a[i] < val) {
						pos++;
					}
				}

				while (val == a[pos]) {
					pos++;
				}

				tmp = a[pos];
				a[pos] = val;
				val = tmp;
				writes++;
			}
		}
		return writes;
	}
}
