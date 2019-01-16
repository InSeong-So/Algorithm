package algorithm.basic;

public class sis_04 {

	public static void main(String[] args) {
		int a = 1;
		int sum = 1;
		for (int i = 0; i < 10; i++) {
			a += i;
			sum += a;
		}
		System.out.println(sum);
	}
}
