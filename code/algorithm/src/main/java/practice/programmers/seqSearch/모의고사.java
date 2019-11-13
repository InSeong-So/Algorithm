package practice.programmers.seqSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사
{
    public static void main(String[] args)
    {
        int[] n = { 1, 2, 3, 4, 5 };
        int[] n2 = { 1, 3, 2, 4, 2 };
        
        solution(n);
    }
    
    static int[] solution(int[] answers)
    {
        int[] student1 = { 1, 2, 3, 4, 5 };
        int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        int[] tempA = new int[3];
        
        for (int i = 0; i < answers.length; i++)
        {
            if (answers[i] == student1[i % 5])
            {
                tempA[0]++;
            }
            if (answers[i] == student2[i % 8])
            {
                tempA[1]++;
            }
            if (answers[i] == student3[i % 10])
            {
                tempA[2]++;
            }
        }
        
        int temp = tempA[0];
        
        for (int i = 1; i < tempA.length; i++)
        {
            System.out.println(i + " / " + tempA[i]);
            if (tempA[i] > temp)
            {
                temp = tempA[i];
            }
        }
        
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i = 0; i < tempA.length; i++)
        {
            if (temp == tempA[i])
            {
                answer.add(i + 1);
            }
            
        }
        
        int[] returnValue = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++)
        {
            returnValue[i] = answer.get(i);
        }
        
        System.out.println(Arrays.toString(returnValue));
        
        return returnValue;
    }
}
