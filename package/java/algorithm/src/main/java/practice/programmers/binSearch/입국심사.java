package practice.programmers.binSearch;

import java.util.Arrays;

public class 입국심사
{
    public int solution(int n, int[] times)
    {
        Arrays.sort(times);
        return (int) find((long) n, times, (long) times.length, times[0], (long) ((long) times[0] * (long) n));
    }
    
    public long find(long n, int[] times, long nExamination, long from, long to)
    {
        long minTime;
        long tmp = n;
        if (from == to)
        {
            return from;
        }
        else
        {
            minTime = (from + to) / 2;// + ((from + to) % 2 == 1? 1 : 0);
            for (int i = 0; i < nExamination; i++)
            {
                tmp -= minTime / (long) times[i];
            }
            if (tmp > 0)
            {
                return find(n, times, nExamination, minTime + 1, to);
            }
            else
            {
                return find(n, times, nExamination, from, minTime);
            }
        }
    }
}
