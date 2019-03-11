package doit2.chap01;
import java.util.Scanner;
// ?���? ?��?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��.

public class TriangleLB {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		System.out.println("?���? ?��?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��.");

		do {
			System.out.print("�? ?�� ?��각형?��?���?? : ");
			n = stdIn.nextInt();
		} while (n <= 0);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print('*');
			System.out.println();
		}
	}
}