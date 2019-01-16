package algorithm.dp.day4;

import java.util.Scanner;

/*
 * D[i][j][k] = i번째 디스크를 돌릴 것이고, 현재 칸은 j만큼 돌아가 있고, 다음 칸은 k만큼 돌아가 있다.
 * 현재 i번째 디스크가 가리키고 있는 값 : (a[i] + j) % 10
 * i번째 디스크를 기준으로 연속 세 칸을 three만큼
 * 연속 두 칸을 two만큼 돌린다.
 * 이제 i번째 디스크는 (a[i] + j + two + three) % 10을 가리키고 있다.
 * 한 칸을 얼마나 돌려야하는지 수식으로 구한다.
 * 총 돌리는 비용 : cost[one] + cost[two] + cost[three]
 * 다음 상태 : D[i+1][(k+two+three)%10][three]
 */

public class Lock {
	public static int n;
	public static String a, b;
	public static int[][][] d;
	public static int[] turn = { 0, 1, 1, 1, 2, 2, 2, 1, 1, 1 };

	public static int go(int i, int j, int k) {
		if (i == n)
			return 0;
		if (d[i][j][k] != -1)
			return d[i][j][k];
		int original = a.charAt(i) - '0';
		original = (original + j) % 10;
		int to = b.charAt(i) - '0';
		for (int two = 0; two < 10; two++) {
			for (int three = 0; three < 10; three++) {
				int from = (original + two + three) % 10;
				int one = to - from;
				if (one < 0)
					one += 10;
				int cost = turn[one] + turn[two] + turn[three];
				cost += go(i + 1, (k + two + three) % 10, three);
				if (d[i][j][k] == -1 || d[i][j][k] > cost) {
					d[i][j][k] = cost;
				}
			}
		}
		return d[i][j][k];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		a = sc.nextLine();
		b = sc.nextLine();
		d = new int[n][10][10];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					d[i][j][k] = -1;
				}
			}
		}
		System.out.println(go(0, 0, 0));
	}
}
