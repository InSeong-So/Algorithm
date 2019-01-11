package algorithm.basic;

public class Max {

	public static void main(String[] args) {
		int a = 7;
		int b = 9;

		System.out.println(min(7, 9));
		System.out.println(max(7, 9));
		System.out.println(mid(3, 5, 9));
	}

	// 최댓값을 구하는 함수
	public static int min(int a, int b) {
		return a <= b ? a : b;
	}

	// 최솟값을 구하는 함수
	public static int max(int a, int b) {
		return a <= b ? b : a;
	}

	// 세 값의 대소 관계 중 중앙값을 구하는 함수
	// 세 값의 대소 관계 조합은 13가지 종류가 있음
	// 조합을 나열한 모양이 나무(tree) 형태이므로 결정 트리(decision tree)라고 함
	// 결정 트리는 왼쪽 끝(a >= b)에서 오른쪽으로 이동하고, 조건이 성립하면 위로, 아니라면 아래로 이동
	// 중앙값을 구하는 과정은 퀵 정렬에도 사용됨
	public static int mid(int a, int b, int c) {
		if (a >= b)
			if (b >= c)
				return b;
			else if (a <= c)
				return a;
			else
				return c;
		else if (a > c)
			return a;
		else if (b > c)
			return c;
		else
			return b;
	}
}
