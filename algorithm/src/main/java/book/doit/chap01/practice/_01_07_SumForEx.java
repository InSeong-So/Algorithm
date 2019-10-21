package book.doit.chap01.practice;

import java.util.Scanner;

class _01_07_SumForEx
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("1부터 n까지 더합니다.");
        System.out.print("n의 입력값 : ");
        int n = stdIn.nextInt();
        
        int sum = 0;
        
        for (int i = 1; i <= n; i++)
        {
            if (i < n)
                System.out.print(i + " + ");
            else
                System.out.print(i);
            sum += i;
        }
        System.out.println(" = " + sum);
    }
}
