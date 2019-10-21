package searchAlgorithm.binarySearch;

import java.util.Scanner;

public class BinarySearch2 {
	// 요소의 수가 n인 배열 a에서 key와 같은 요소를 이진 검색
	public static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key) {
				return pc;
			} else if (a[pc] < key) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pl <= pr);

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요소 개수 : ");
		int num = sc.nextInt();
		int[] array = new int[num];

		System.out.println("array[0] : ");
		array[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("array[" + i + "] : ");
				array[i] = sc.nextInt();
			} while (array[i] < array[i - 1]);
		}
		System.out.println("검색할 값 : ");
		int key = sc.nextInt();

		int idx = binSearch(array, num, key);

		if (idx == -1) {
			System.out.println("요소가 없습니다.");
		} else {
			System.out.println(key + " : array[" + idx + "]");
		}
	}
}
