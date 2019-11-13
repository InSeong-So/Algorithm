package book.doit.chap01.practice;

import java.util.Scanner;

class _01_11_DigitsNo
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("2자리의 정수를 입력하세요.");
        
        int n;
        do
        {
            System.out.print("입력 : ");
            n = stdIn.nextInt();
        } while (n <= 0);
        
        int no = 0;
        while (n > 0)
        {
            n /= 10;
            no++;
        }
        
        System.out.println("변수 no의 값은 " + no + "가(이) 되었습니다.");
    }
}