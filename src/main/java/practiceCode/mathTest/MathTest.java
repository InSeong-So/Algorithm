package practiceCode.mathTest;

public class MathTest {

	public static void main(String[] args) {
		// 절대값
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("절대값 v1 = " + v1);
		System.out.println("절대값 v2 = " + v2);

		// 올림값
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println("올림값 v3 = " + v3);
		System.out.println("올림값 v4 = " + v4);

		// 버림값
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println("버림값 v5 = " + v5);
		System.out.println("버림값 v6 = " + v6);

		// 최댓값
		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.3, 2.5);
		System.out.println("최댓값 v7 = " + v7);
		System.out.println("최댓값 v8 = " + v8);

		// 최솟값
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.3, 2.5);
		System.out.println("최솟값 v9 = " + v9);
		System.out.println("최솟값 v10 = " + v10);

		// 랜덤값(0.0 <= Math.random() < 1.0 범위에 속하는 하나의 double 타입의 값 리턴)
		double v11 = Math.random();
		System.out.println("랜덤값 v11 = " + v11);
		/* 활용법 !!
		 * 
		 * 1. 각 변에 10을 곱하면 해당 범위에 속하는 하나의 double 타입의 값을 얻을 수 있음
		 * 범위 : (0.0 * 10) <= (Math.random() * 10) < (1.0 * 10)
		 * 
		 * 2. 각 변을 int 타입으로 강제 변환하면 해당 범위에 속하는 하나의 int 값을 얻을 수 있음
		 * 범위 : (int)(0.0 * 10) <= (int)(Math.random() * 10) < (int)(1.0 * 10)
		 * 
		 * 3. 각 변에 1을 더하면 해당 범위에 속하는 하나의 정수를 얻을 수 있음
		 * 범위 : (int)(0.0 * 10) + 1 <= (int)(Math.random() * 10) + 1 < (int)(1.0 * 10) + 1
		 * 
		 * 예제 : 주사위 굴리기
		 * int num = (int)(Math.random() * 6) + 1;
		 * */

		// 가까운 정수의 실수값
		double v12 = Math.rint(5.3);
		double v13 = Math.rint(5.7);
		System.out.println("가까운 정수의 실수값 v12 = " + v12);
		System.out.println("v13 = " + v13);

		// 반올림값(항상 소수점 첫째 자리에서 반올림한 정수값을 리턴)
		long v14 = Math.round(5.3);
		long v15 = Math.round(5.7);
		System.out.println("반올림값 v14 = " + v14);
		System.out.println("반올림값 v15 = " + v15);

		/* 반올림값(원하는 소수 자릿수에서 반올림된 값을 얻기 위함)
		 * 
		 * 반올림할 자리가 소수점 첫째 자리가 되도록 10(n)을 곱한다.
		 * 리턴받은 값을 10(n).0을 나누면 원하는 정수값이 된다.
		 * */
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1);
		double v16 = temp2 / 100.0;
		System.out.println("반올림값 v16 = " + v16);
	}
}
