package algorithm.doit.chap01.ex;
import java.util.Scanner;
// 1, 2, ??, n?�� ?��?�� 구합?��?��  (?��1 + 2 + ?? + n = 999?���? 출력?��)

class _01_07_SumForEx {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1�??�� n까�??�� ?��?�� 구합?��?��.");
		System.out.print("n?�� 값：");
		int n = stdIn.nextInt();

		int sum = 0; // ?��

		for (int i = 1; i <= n; i++) {
			if(i < n)
				System.out.print(i + " + ");
			else
				System.out.print(i);
			sum += i; // sum?�� i�? ?��?��
		}
		System.out.println(" = " + sum);
	}
}
