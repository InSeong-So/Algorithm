package doit2.chap02.practice;
import java.util.Scanner;
// 연내의 경과 일 수를 구합니다(while문을 사용).

class _02_08_DayOfYearWhile {
	// 각 달의 일 수
	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
	};

	// 서기 year년은 윤년인가? (윤년：1／평년：0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	// 서기 y년 m월 d일의 연내의 경과일수를 구합니다.
	static int dayOfYear(int y, int m, int d) {
		while (--m != 0)
			d += mdays[isLeap(y)][m - 1];
		return (d);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry; // 한 번더 ?

		System.out.println("연내의 경과 일 수를 구합니다.");

		do {
			System.out.print("년：");
			int year = stdIn.nextInt(); // 년
			System.out.print("월：");
			int month = stdIn.nextInt(); // 월
			System.out.print("일：");
			int day = stdIn.nextInt(); // 일

			System.out.printf("연내 %d일째입니다.\n", dayOfYear(year, month, day));

			System.out.print("한번 더 할까요? (1.예/0.아니오)：");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
}
