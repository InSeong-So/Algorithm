package questions.one._01;

/*
 * - 1.5 하나 빼기
 * - 문자열을 편집하는 방법에는 세 가지 종류가 있다.
 * - 문자 삽입, 문자 삭제, 문자 교체.
 * - 문자열 두 개가 주어졌을 때, 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.
 */
public class one05
{
    
    // solution 1. Time Complexity O(n)
    // solution 1.0
    boolean oneEditAway(String first, String second)
    {
        if (first.length() == second.length())
            return oneEditReplace(first, second);
        else if (first.length() + 1 == second.length())
            return oneEditInsert(first, second);
        else if (first.length() - 1 == second.length())
            return oneEditInsert(second, first);
        
        return false;
    }
    
    // solution 1.1
    private boolean oneEditReplace(String s1, String s2)
    {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
            {
                if (foundDifference)
                    return false;
                foundDifference = true;
            }
        }
        return true;
    }
    
    // solution 1.2 s1에 문자 하나를 삽입해서 s2를 만들 수 있는지 확인
    private boolean oneEditInsert(String s1, String s2)
    {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length())
        {
            if (s1.charAt(index1) != s2.charAt(index2))
            {
                if (index1 != index2)
                    return false;
                index2++;
            }
            else
            {
                index1++;
                index2++;
            }
        }
        return true;
    }
    
    /************************************************************************/
    
    // solution 2. Time Complexity O(n)
    // solution 2.0
    boolean oneEditAway2(String first, String second)
    {
        // 길이 체크
        if (Math.abs(first.length() - second.length()) > 1)
            return false;
        
        // 길이가 짧은 문자열과 긴 문자열 찾기
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;
        
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length())
        {
            if (s1.charAt(index1) != s2.charAt(index2))
            {
                // 반드시 첫 번째로 다른 문자여야 한다.
                if (foundDifference)
                    return false;
                foundDifference = true;
                if (s1.length() == s2.length()) // 교체의 경우 짧은 문자열의 포인터 증가
                    index1++;
            }
            else
            {
                index1++; // 동일하다면 짧은 문자열의 포인터 증가
            }
            index2++; // 긴 문자열의 포인터는 언제나 증가
        }
        return true;
    }
}
