package algorithm.basic;

public class sis_02 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			// sum += (i += 2);
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
