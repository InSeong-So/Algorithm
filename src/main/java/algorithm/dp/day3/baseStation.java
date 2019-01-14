package algorithm.dp.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 조건을 추가하고 풀어야 DP가 가능하다.
 * (추가) 기지국은 겹치지 않고 연속적이어야 한다.
 * 기지국은 항상 정사각형 모양이다.
 * D[i] = i번째 건물까지 통신 범위에 포함시키는 최소 설치 비용
 * D[i] = min(D[j-1] + (j ~ i까지 통신범위에 포함하는 기지국을 설치하는 비용)
 */

public class baseStation implements Comparable<baseStation> {

	int x, y;

	baseStation(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int compareTo(baseStation that) {
		if (this.x < that.x) {
			return -1;
		} else if (this.x == that.x) {
			if (this.y < that.y) {
				return -1;
			} else if (this.y == that.y) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<baseStation> a = new ArrayList<baseStation>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (y < 0) {
				y *= -1;
			}
			a.add(new baseStation(x, y));
		}
		Collections.sort(a);
		a.add(0, new baseStation(0, 0));
		long[] d = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			d[i] = 100000000;
			int up = 0;
			for (int j = i; j >= 1; j--) {
				up = Math.max(up, a.get(j).y);
				int square = Math.max(a.get(i).x - a.get(j).x, up * 2);
				if (d[i] > d[j - 1] + square) {
					d[i] = d[j - 1] + square;
				}
			}
		}
		System.out.println(d[n]);
	}
}
