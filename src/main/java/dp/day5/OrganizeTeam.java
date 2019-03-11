package dp.day5;

import java.util.Scanner;

public class OrganizeTeam {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			d[i] = d[i - 1];
			int max = a[i];
			int min = a[i];
			for (int j = i - 1; j >= 1; j--) {
				if (max < a[j])
					max = a[j];
				if (min > a[j])
					min = a[j];
				int cur = d[j - 1] + (max - min);
				if (d[i] < cur) {
					d[i] = cur;
				}
			}
		}
		System.out.println(d[n]);
	}
}
