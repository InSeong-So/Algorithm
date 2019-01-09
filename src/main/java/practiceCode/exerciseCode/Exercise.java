package practiceCode.exerciseCode;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		Exercise09();
	}

	public static void Exercise07() {
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };

		for (int i : array) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println(max);
	}

	public static void Exercise08() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		double avg = 0.0;
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			for (int k : array[i]) {
				sum = sum + k;
				count++;
			}
		}

		avg = sum / count;

		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}

	public static void Exercise09() {
		boolean run = true;
		int studentNum = 0;
		int[] score = null;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("---------------------------------------------------------");
			System.out.println("선택 >> ");

			int selectNo = sc.nextInt();

			switch (selectNo) {
			case 1:
				studentNum = sc.nextInt();
				break;
			case 2:
				if (studentNum != 0) {
					score = new int[studentNum];
					for (int i = 0; i < studentNum; i++) {
						System.out.println("score[" + i + "] >> ");
						score[i] = sc.nextInt();
					}
					break;
				} else {
					System.out.println("잘못된 선택입니다.");
					break;
				}
			case 3:
				for (int i = 0; i < score.length; i++) {
					System.out.println("scores[" + i + "] : " + score[i]);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0.0;
				for (int i = 0; i < score.length; i++) {
					if (score[i] > max) {
						max = score[i];
					}
					sum = sum + score[i];
				}
				avg = sum / score.length;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 : " + avg);
				break;
			case 5:
				run = false;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
