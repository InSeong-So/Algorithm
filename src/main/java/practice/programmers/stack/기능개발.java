package practice.programmers.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
	public int[] solution1(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		int len = progresses.length;

		int num = 0;
		for (int i = 0; i <= len; i++) {
			if (i == len) {
				q.add(num);
				break;
			}
			if (progresses[i] >= 100) {
				num++;
				continue;
			}
			if (num != 0) {
				q.add(num);
			}

			num = 0;
			int remain = 100 - progresses[i];
			int day = remain / speeds[i];
			if (remain % speeds[i] != 0) {
				day++;
			}

			for (int j = i; j < len; j++) {
				progresses[j] += (day * speeds[j]);
			}
			num++;
		}

		int[] answer = new int[q.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = q.remove();
		}
		return answer;
	}

	public int[] solution2(int[] progresses, int[] speeds) {
		int[] dayOfend = new int[100];
		int day = -1;
		for (int i = 0; i < progresses.length; i++) {
			while (progresses[i] + (day * speeds[i]) < 100) {
				day++;
			}
			dayOfend[day]++;
		}
		return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
	}
}
