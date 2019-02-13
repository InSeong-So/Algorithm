package algorithm.doit.chap01;
import java.util.Scanner;
// ?��?�� 받�? ?��?��값의 ?��?��/?��?��/0?�� ?��?��

class Judge123A {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("?��?���?? ?��?��?��?��?��.�??");
		int n = stdIn.nextInt();

		if (n == 1)
			System.out.println("?�� ?��?�� 1?��?��?��.");
		else if (n == 2)
			System.out.println("?�� ?��?�� 2?��?��?��.");
		else if (n == 3)
			System.out.println("?�� ?��?�� 3?��?��?��.");
	}
}
