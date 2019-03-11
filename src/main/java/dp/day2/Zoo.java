package dp.day2;

import java.util.Scanner;

public class Zoo {

	/* 가능한 배치의 수
	 * 0 : X X
	 * 1 : X O
	 * 2 : O X
	 * 3 : O O 
	 * 3번은 조건에 부합하지 않으므로 총 3개의 경우의 수만 존재
	 * N칸에 0번이 올 경우 올 수 있는 경우의 수는 0, 1, 2
	 * N칸에 1번이 올 경우 올 수 있는 경우의 수는 0, 2
	 * N칸에 2번이 올 경우 올 수 있는 경우의 수는 0, 1
	 * 각 경우의 수를 구하여 더한 후 최종적으로 9901로 나누기 연산 해주면 됨.
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] outputArray = new int[n + 1][3];
		outputArray[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			outputArray[i][0] = outputArray[i - 1][0] + outputArray[i - 1][1] + outputArray[i - 1][2];
			outputArray[i][1] = outputArray[i - 1][0] + outputArray[i - 1][2];
			outputArray[i][2] = outputArray[i - 1][0] + outputArray[i - 1][1];
			for (int j = 0; j < 3; j++) {
				outputArray[i][j] = outputArray[i][j] % 9901;
			}
		}
		System.out.println((outputArray[n][0] + outputArray[n][1] + outputArray[n][2]) % 9901);
	}
}
