import algorithm.custom.CustomList;

public class _20191113
{
    public static void main(String[] args)
    {
        int[] n = CustomList.randomIntArray(11, 10);
    }
    
    public static int seqSearch(int[] n, int t)
    {
        int i = 0;
        
        while (true)
        {
            if (i == n.length)
                return -1;
            if (n[i] == t)
                return i;
            
            i++;
        }
    }
    
    public static int seqSearchSen(int[] n, int t)
    {
        int i = 0;
        
        while (true)
        {
            if (n[i] == t)
                break;
            i++;
        }
        
        return i == n.length ? -1 : i;
    }
    
    public static int binSearch(int[] n, int t)
    {
        int start = 0;
        int end = n.length - 1;
        
        do
        {
            int center = (start + end) / 2;
            
            if (n[center] == t)
                return center;
            else if (n[center] < t)
                start = center + 1;
            else
                end = center - 1;
        } while (start <= end);
        return -1;
    }
}
