package algorithm.doit.chap01.practice;
import java.util.Scanner;
// 3개의 값의 최솟값을 구하?�� 출력

class _01_02_Min3 {
   // a, b, c?�� 최솟값을 구하?�� 반환
   static int min3(int a, int b, int c) {
      int min = a;         			// 최솟�?
      if (b < min) min = b;
      if (c < min) min = c;

      return min;
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);
      int a, b, c;

      System.out.println("?�� ?��?��?�� 최솟값을 구합?��?��.");
      System.out.print("a?�� 값：");  a = stdIn.nextInt();
      System.out.print("b?�� 값：");  b = stdIn.nextInt();
      System.out.print("c?�� 값：");  c = stdIn.nextInt();

      int min = min3(a, b, c);   	// a, b, c?�� 최솟�?

      System.out.println("최솟값�? " + min + "?��?��?��.");
   }
}