package algorithm.dp.one;

import java.util.Scanner;

public class RGB_distance_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		int[][] inputArray = new int[index + 1][3]; // 배열 값
		int[][] outputArray = new int[index + 1][3]; // 계산 값
		for (int i = 1; i <= index; i++) {
			for (int j = 0; j < 3; j++) {
				inputArray[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= index; i++) {
			outputArray[i][0] = min(outputArray[i - 1][1], outputArray[i - 1][2]) + inputArray[i][0];
			outputArray[i][1] = min(outputArray[i - 1][0], outputArray[i - 1][2]) + inputArray[i][1];
			outputArray[i][2] = min(outputArray[i - 1][0], outputArray[i - 1][1]) + inputArray[i][2];
		}

		System.out.println(outputArray[index][0] + " " + outputArray[index][1] + " " + outputArray[index][2]);
	}

	// 최솟값 구하는 메소드 작성
	public static int min(int a, int b) {
		return a <= b ? a : b;
	}
}
