package Etc;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(4));
	}

	public static int factorial(int input) {
		if (input <= 1) {
			return input;
		} else {
			return factorial(input - 1) * input;
		}

	}
}
