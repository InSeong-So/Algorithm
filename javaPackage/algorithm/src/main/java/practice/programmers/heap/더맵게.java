package practice.programmers.heap;

import java.util.PriorityQueue;

public class 더맵게
{
    public int solution(int[] scoville, int K)
    {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        for (int aScoville : scoville)
        {
            heap.offer(aScoville);
        }
        
        while (heap.peek() <= K)
        {
            if (heap.size() == 1)
            {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();
            
            int result = a + (b * 2);
            
            heap.offer(result);
            answer++;
        }
        return answer;
    }
}
