package practice.programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class 라면공장
{
    public int solution(int stock, int[] dates, int[] supplies, int k)
    {
        int answer = 0;
        int index = 0;
        int index2 = 0;
        int st = stock;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        while (st < k)
        {
            for (int i = index; i < dates.length; i++)
            {
                if (dates[i] <= st)
                {
                    pq.offer(supplies[i]);
                    index2 = i;
                }
            }
            index = index2 + 1;
            st += pq.poll();
            answer++;
        }
        return answer;
    }
}
