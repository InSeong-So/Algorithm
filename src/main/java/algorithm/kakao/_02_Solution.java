package algorithm.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _02_Solution {

	// 스테이지와 함께 실패율을 저장해야함
	class Fail {
		int stages;
		double rate;

		Fail(int stages, double rate) {
			this.stages = stages;
			this.rate = rate;
		}
	}

	Comparator<Fail> comp = new Comparator<Fail>() {
		public int compare(Fail a, Fail b) {
			if (a.rate < b.rate) {
				return 1;
			} else if (a.rate > b.rate) {
				return -1;
			} else {
				if (a.stages > b.stages) {
					return 1;
				} else if (a.stages < b.stages) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	};

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		List<Fail> fails = new ArrayList<Fail>();
		int total = stages.length;

		int[] users = new int[N + 1];
		for (int s : stages) {
			users[s - 1]++;
		}

		for (int i = 0; i < N; ++i) {
			if (users[i] == 0) {
				fails.add(new Fail(i + 1, 0));
			} else {
				fails.add(new Fail(i + 1, (double) users[i] / total));
				total -= users[i];
			}
		}

		Collections.sort(fails, comp);

		for (int i = 0; i < N; ++i) {
			answer[i] = fails.get(i).stages;
		}

		return answer;
	}
}
