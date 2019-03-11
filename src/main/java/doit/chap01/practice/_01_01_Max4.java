package doit2.chap01.practice;
import java.util.Scanner;
// ?�� 값의 최댓값을 구하?�� ?��???��

class _01_01_Max4 {
	// a, b, c, d?�� 최댓값을 구하?�� 반환
	static int max4(int a, int b, int c, int d) {
		int max = a; 	// 최댓�?
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		if (d > max)
			max = d;

		return max;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a, b, c, d;

		System.out.println("?�� ?��?��?�� 최댓값을 구합?��?��.");
		System.out.print("a?�� 값：");
		a = stdIn.nextInt();
		System.out.print("b?�� 값：");
		b = stdIn.nextInt();
		System.out.print("c?�� 값：");
		c = stdIn.nextInt();
		System.out.print("d?�� 값：");
		d = stdIn.nextInt();

		int max = max4(a, b, c, d); 	// a, b, c, d?�� 최댓�?

		System.out.println("최댓값�? " + max + "?��?��?��.");
	}
}
