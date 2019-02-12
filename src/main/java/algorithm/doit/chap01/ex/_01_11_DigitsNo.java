package algorithm.doit.chap01.ex;
import java.util.Scanner;
// ?��?�� ?��?��값의 ?��릿수�? 구하?�� ?��???��

class _01_11_DigitsNo {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("?��?�� ?��?��값의 ?��릿수�? 구합?��?��.");

		int n;
		do {
			System.out.print("?��?��값：");
			n = stdIn.nextInt();
		} while (n <= 0);

		int no = 0; 			// ?��릿수
		while (n > 0) {
			n /= 10; 			// n?�� 10?���? ?��?��
			no++;
		}

		System.out.println("�? ?��?�� " + no + "?��리입?��?��.");
	}
}