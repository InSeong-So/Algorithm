package book.doit.chap06.practice;

import java.util.Scanner;

class _06_12_QuickSortEx1B
{
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2)
    {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    // 퀵정렬
    static void quickSort(int[] a, int left, int right)
    {
        _06_00_IntStack lstack = new _06_00_IntStack(right - left + 1);
        _06_00_IntStack rstack = new _06_00_IntStack(right - left + 1);
        
        lstack.push(left);
        rstack.push(right);
        
        while (lstack.isEmpty() != true)
        {
            int pl = left = lstack.pop(); // 왼쪽 커서
            int pr = right = rstack.pop(); // 오른쪽 커서
            int x = a[(left + right) / 2]; // 피벗은 중앙의 요소
            
            do
            {
                while (a[pl] < x)
                    pl++;
                while (a[pr] > x)
                    pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);
            
            if (pr - left < right - pl)
            {
                int temp;
                temp = left;
                left = pl;
                pl = temp;
                temp = right;
                right = pr;
                pr = temp;
            }
            if (left < pr)
            {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right)
            {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("퀵정렬 ");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];
        
        for (int i = 0; i < nx; i++)
        {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }
        
        quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬
        
        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
