package practice.programmers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가장큰수
{
    public static String solution1(int[] numbers)
    {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);
        
        return sb.toString();
    }
    
    public static String solution2(int[] numbers)
    {
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
        {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : list)
        {
            sb.append(i);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0')
        {
            return "0";
        }
        else
        {
            return answer;
        }
    }
}
