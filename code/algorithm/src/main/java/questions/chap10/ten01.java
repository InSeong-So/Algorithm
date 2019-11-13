package questions.chap10;

public class ten01
{
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 };
        int[] b = { 7, 8, 9, 10 };
        
        merge(a, b, 5, 4);
        
        StringBuffer sb = new StringBuffer();
        
        for (int j : a)
        {
            sb.append(j);
        }
        
        System.out.println(sb.toString());
        
    }
    
    /**
     * 
     * @param a
     *            b와 합쳐질 배열, 없는 값은 0으로 표기
     * @param b
     *            a에 합쳐질 배열
     * @param lastA
     *            a배열에 존재하는 값의 마지막 인덱스(0 제외)
     * @param lastB
     *            b배열에 존재하는 값의 마지막 인덱스(0 제외)
     */
    static void merge(int[] a, int[] b, int lastA, int lastB)
    {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;
        
        while (indexA >= 0 && indexB >= 0)
        {
            if (a[indexA] > b[indexB])
            {
                a[indexMerged] = a[indexA];
            }
            else
            {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}
