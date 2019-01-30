package algorithm.kakao;

public class test {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] users = new int[N + 1];

		int total = stages.length;
		for (int s : stages) {
			System.out.println("시작");
			System.out.println(s);
			System.out.println("구분");
			System.out.println(users[s - 1]++);
			System.out.println("종료");
			System.out.println();
		}
		// users[0] = 1;
		// users[1] = 3;
		// users[2] = 2;
		// users[3] = 1;
		// users[4] = 0;
		// users[5] = 1;

		for (int i = 0; i < users.length; i++) {
			System.out.println(i + "번째 :" + users[i]);
			// System.out.println((double) users[i] / total);
			// total -= users[i];
		}
	}
}
