package algorithm.dp.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class TheaterSeat {

	/* 피보나치 수열을 사용하는 것이 편함
	 * VIP 회원이 없을 때, D[i] = 좌석이 i개일 때, 앉는 방법의 수
	 * D[i] = D[i-1] + D[i-2]
	 * VIP 회원이 있을 때, 좌석의 처음과 끝에 자리가 있다고 가정한 후 고정 배열의 크기를 계산
	 * 고정 좌석을 기준으로 나눈 좌석의 크기를 구한 후 모두 곱해주면 됨
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1이상 40 이하의 좌석
		long[] d = new long[41];
		// 피보나치 수 구하기
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= 40; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		System.out.print("전체 좌석 개수를 입력해주세요. ");
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		// 처음 좌석값 자동 입력
		a.add(0);
		System.out.print("고정석의 개수를 입력해주세요. ");
		int m = sc.nextInt();
		while (m-- > 0) {
			System.out.print("고정석의 좌석 번호를 입력해주세요. ");
			a.add(sc.nextInt());
		}
		// 끝 좌석값 자동 입력
		a.add(n + 1);
		// 출력할 방법의 수
		long result = 1;
		for (int i = 1; i < a.size(); i++) {
			// 끝 좌석값만큼 빼주므로 -1
			result *= d[a.get(i) - a.get(i - 1) - 1];
		}
		System.out.println(result);

		// 1 '2' 3 '4' 5 6 '7' 8 9 10 11 12
	}

}
