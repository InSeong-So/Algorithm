package algorithm.dp.day2;

import java.util.Scanner;

public class GreedyPanda {

	/* N*N 크기의 이차원 배열에서 최대 부분 증가 수열을 구하는 문제임
	 * 
	 * 	14	9 	12 	10
	 * 	1	11 	5 	4
	 * 	7	15 	2 	13
	 * 	6 	3 	16 	8
	 * 
	 * */

	/* 보통 상하좌우 4방향을 조건으로 주지 않고 두방향 또는 세방향으로 준다.
	 * 이 문제의 경우 반드시 큰 수로만 이동해야하므로 점화식에 사이클이 없다.
	 * 그 말인 즉슨 이동할 좌표에 값이 채워져 있다는 것이다.
	 * 이런 스타일은 재귀를 이용하면 쉽다.
	 * D[i][j] = 판다가 (i, j)에서 이동을 시작했을 때, 최대한 살 수 있는 일 수
	 * D[i][j] = max(D[x][y]) + 1
	 * (i, j) => (x, y) 로 이동하기 위한 조건
	 * 1. (x, y)는 N*N 범위 내여야 한다.
	 * 2. (x, y)는 (i, j)보다 큰 수이다.
	 */

	static int n;
	static int[][] a = new int[500][500];
	static int[][] d = new int[500][500];
	static int[] dx = { 0, 0, 1, -1 }; // 이동할 x 좌표 선언
	static int[] dy = { 1, -1, 0, 0 }; // 이동할 y 좌표 선언

	static int go(int i, int j) {
		if (d[i][j] != 0) { // 판다는 0일을 살 수 없다.
			return d[i][j];
		}
		d[i][j] = 1; // 위와 같이 어떤 칸에 있어도 하루는 살 수 있으므로 1로 선언
		// 범위 안에 있는지, 더 큰 수가 있는지 두 가지 조건 적용
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= n || y < 0 || y >= n) {
				continue;
			}
			if (a[i][j] < a[x][y]) {
				d[i][j] = Math.max(d[i][j], go(x, y) + 1); // +1을 해주는 이유는 (i, j) 에서 (x, y)로 이동하는 만큼 1일이 증가하기 때문
			}
		}
		return d[i][j];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, go(i, j));
			}
		}
		System.out.println(result);
	}
}
