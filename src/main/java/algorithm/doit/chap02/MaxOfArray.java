package algorithm.doit.chap02;
import java.util.Scanner;
// 배열 요소의 최댓값을 나타냅니다(값을 입력 받음).

class MaxOfArray {
	// 배열 a의 최댓값을 구하여 반환합니다.
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = stdIn.nextInt();				// 배열의 요솟수를 입력 받음

		int[] height = new int[num];			// 요솟수가 num인 배열을 생성

		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "]：");
			height[i] = stdIn.nextInt();
		}
	
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}
}