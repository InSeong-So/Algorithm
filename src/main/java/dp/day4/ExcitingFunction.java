package dp.day4;

import java.util.Scanner;

public class ExcitingFunction {
	static int[][][] d = new int[21][21][21];

	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		if (d[a][b][c] > 0)
			return d[a][b][c];

		if (a < b && b < c) {
			return d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return d[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == -1 && b == -1 && c == -1)
				break;

			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}
	}
}
