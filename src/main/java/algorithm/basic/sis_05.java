package algorithm.basic;

import java.util.Scanner;

public class sis_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 2;
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 2; i < n; i++) {
			c = a + b;
			sum += c;
			a = b;
			b = c;
		}
		System.out.println(sum);
	}
}
