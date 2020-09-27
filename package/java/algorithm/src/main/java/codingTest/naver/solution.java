package codingTest.naver;

public class solution
{
    public static void main(String[] args)
    {
        String s = "ttasdlkfjasoidfbkpoqkc";
        System.out.println(solution(s, "abc"));
    }
    
    public static String solution(String m, String k)
    {
        String answer = "";
        String temp = "";
        String temp2 = "";
        
        for (int i = 0; i < 4; i++)
        {
            // 마지막일 때
            if (i == 3)
            {
                answer += replaceTarget(m.substring(i * (m.length() / 4), m.length()), k);
                break;
            }
            temp = m.substring(i * (m.length() / 4), ((i + 1) * (m.length() / 4)));
            
            temp2 = replaceTarget(temp, k);
            
            answer += temp;
        }
        
        return answer;
    }
    
    public static String replaceTarget(String m, String k)
    {
        boolean flag = false;
        
        for (int i = 0; i < m.length(); i++)
        {
            for (int j = 0; j < k.length(); j++)
            {
                if (m.charAt(i) == k.charAt(j))
                {
                    m.replace(String.valueOf(k.charAt(j)), "");
                }
            }
        }
        
        return "";
    }
}
