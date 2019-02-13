package algorithm.doit.chap01;
import java.util.Scanner;
// 2?��리의 ?��?��(10 ~ 99)�? ?��?��?��?��?��.

class Digits {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;

		System.out.println("2?��리의 ?��?���? ?��?��?��?��?��.");

		do {
			System.out.print("?��?���?");
			no = stdIn.nextInt();
		} while (no < 10 || no > 99);

		System.out.println("�??�� no?�� 값�? " + no + "�?(?��) ?��?��?��?��?��.");
	}
}