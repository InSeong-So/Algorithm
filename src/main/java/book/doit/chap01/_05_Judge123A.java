package book.doit.chap01;

import java.util.Scanner;

class _05_Judge123A
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요.");
        int n = stdIn.nextInt();
        
        if (n == 1)
            System.out.println("이 수는 1입니다.");
        else if (n == 2)
            System.out.println("이 수는 2입니다.");
        else if (n == 3)
            System.out.println("이 수는 3입니다.");
    }
}
