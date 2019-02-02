package algorithm.codility;

import java.util.LinkedList;
import java.util.List;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;
		solution(A, 3);
	}

	public static int[] solution(int[] A, int K) {

		if (K == A.length || K == 0) {
			return A;
		} else if (A.length <= 1) {
			return A;
		}

		List<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < A.length; ++i) {
			list.add(A[i]);
		}

		for (int j = 0; j < K; ++j) {
			list.add(0, list.get((list.size() - 1)));
			list.remove(list.size() - 1);
		}

		int[] answer = new int[list.size()];

		for (int z = 0; z < list.size(); ++z) {
			answer[z] = list.get(z);
		}
		return answer;
	}
}
