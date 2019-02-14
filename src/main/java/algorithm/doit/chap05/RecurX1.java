package algorithm.doit.chap05;
import java.util.Scanner;
// 꼬리 재귀가 없는 재귀 함수 이해하기

class RecurX1 {
	// 꼬리 재귀를 제거했습니다. 
	static void recur(int n) {
		while (n > 0) {
			recur(n - 1);
			System.out.println(n);
			n = n - 2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();

		recur(x);
	}
}
