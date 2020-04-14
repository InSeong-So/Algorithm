package sortingAlgorithm.fSort;

import java.util.Scanner;

public class FSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("도수 정렬 시작");
		System.out.println("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			do {
				System.out.println("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while (x[i] < 0);
		}

		// 배열 x의 최댓값을 구하여 max에 대입
		int max = x[0];
		for (int i = 1; i < nx; i++) {
			if (x[i] > max) {
				max = x[i];
			}

			fSort(x, max);

			System.out.println("오름차순 정렬 결과");
		}
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] : ");
		}
	}

	static void fSort(int[] a, int max) {
		int[] f = new int[max + 1];
		int[] b = new int[a.length];
		// 1단계 도수분포표 만들기
		for (int i = 0; i < a.length; i++) {
			f[a[i]]++;
		}
		// 2단계 누적도수분포표 만들기
		for (int i = 1; i <= max; i++) {
			f[i] += f[i - 1];
		}
		// 3단계 목적 배열 만들기
		for (int i = a.length - 1; i >= 0; i--) {
			b[--f[a[i]]] = a[i];
		}
		// 4단계 배열 복사하기
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}
}
