package algorithm.sis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 2회차 문제풀이
 * 
 * @author 소인성
 * @date 2019-10-30
 */
public class _20191030
{
    public static void main(String[] args)
    {
        int[] n = { 8, 1, 45, 21, 22, 37, 6, 7, 2, 79 };
        int i = 10;
        int j = 153248976;
        
        solution1(n);
        solution2(i);
        solution3();
        solution4(n);
        // 입력 문제이므로 주석처리함
        // solution5();
        solution6(j);
        solution7(n);
    }
    
    /**
     * 1번 문제
     * 
     * @param n
     * @return
     */
    public static void solution1(int[] n)
    {
        System.out.println("1번 문제");
        int maxNum = n[0];
        int minNum = n[0];
        
        for (int j : n)
        {
            if (maxNum < j)
                maxNum = j;
            else if (minNum > j)
                minNum = j;
        }
        
        System.out.println("최댓값은 : " + maxNum);
        System.out.println("최솟값은 : " + minNum);
        System.out.println("=========================================");
    }
    
    /**
     * 2번 문제
     * 
     * @param i
     * @return
     */
    public static void solution2(int i)
    {
        System.out.println("2번 문제");
        int sumValue = 0;
        int temp = 1;
        
        for (int j = 0; j < i; j++)
        {
            sumValue = j + temp;
            temp = sumValue;
        }
        
        System.out.println(i + "번째 항까지의 합 : " + sumValue);
        System.out.println("=========================================");
    }
    
    /**
     * 3번 문제
     * 
     */
    public static void solution3()
    {
        System.out.println("3번 문제");
        int sumValue = 0;
        
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 == 0)
                i *= -1;
            
            sumValue += i;
            
            if (i < 0)
                i *= -1;
        }
        
        System.out.println("총합 : " + sumValue);
        System.out.println("=========================================");
    }
    
    /**
     * 4번 문제
     * 
     * @param n
     */
    public static void solution4(int[] n)
    {
        System.out.println("4번 문제");
        int temp = 0;
        
        for (int i = 0; i < n.length; i++)
        {
            for (int j = i + 1; j < n.length; j++)
            {
                if (n[i] > n[j])
                {
                    temp = n[j];
                    n[j] = n[i];
                    n[i] = temp;
                }
            }
        }
        System.out.print("[ ");
        for (int a : n)
        {
            System.out.print(" " + a + " ");
        }
        System.out.println(" ]");
        System.out.println("=========================================");
    }
    
    /**
     * 5번 문제
     * 
     */
    public static void solution5()
    {
        System.out.println("5번 문제");
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();
        
        List<String> list = new ArrayList<String>();
        String temp = "";
        
        for (int i = 0; i <= count; i++)
        {
            temp = sc.nextLine();
            if (!list.contains(temp))
                list.add(temp);
        }
        
        //        list.sort(String::compareToIgnoreCase);
        //        Collections.sort(list);
        
        Comparator<String> myComparator = new Comparator<String>() {
            public int compare(String x, String y)
            {
                if (x.length() > y.length())
                {
                    return 1;
                }
                else if (x.length() == y.length())
                {
                    return x.compareTo(y);
                }
                return -1;
            }
        };
        
        Collections.sort(list, myComparator);
        
        System.out.print("[ ");
        for (String str : list)
        {
            System.out.print(" " + str + " ");
        }
        System.out.println(" ]");
        System.out.println("=========================================");
    }
    
    /**
     * 6번 문제
     * 
     * @param n
     */
    public static void solution6(int n)
    {
        System.out.println("6번 문제");
        int count = 0;
        int temp = n;
        
        while (temp != 0)
        {
            count++;
            temp /= 10;
        }
        
        temp = n;
        
        Integer[] answer2 = new Integer[count];
        
        for (int i = answer2.length - 1; i >= 0; i--)
        {
            answer2[i] = temp % 10;
            temp /= 10;
        }
        
        List<Integer> answer = Arrays.asList(answer2);
        
        Collections.sort(answer, new Comparator<Integer>() {
            
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return Integer.compare(o2, o1);
            }
        });
        
        System.out.print("[ ");
        for (int i : answer)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println(" ]");
        System.out.println("=========================================");
    }
    
    /**
     * 7번 문제
     * 
     * @param n
     * @return
     */
    public static void solution7(int[] n)
    {
        System.out.println("7번 문제");
        String[] arr = new String[n.length];
        
        for (int i = 0; i < n.length; i++)
            arr[i] = String.valueOf(n[i]);
        
        // jdk 8 사용 시
        // Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        Arrays.sort(arr, new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2)
            {
                return (o2 + o1).compareTo(o1 + o2);
            }
            
        });
        
        if (arr[0].equals("0"))
            System.out.println("0");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
        
        System.out.println("정수를 이어 붙여 만든 가장 큰 수는 : "+sb.toString());
        System.out.println("=========================================");
    }
}
