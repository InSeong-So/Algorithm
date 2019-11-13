package questions.chap01;

/*
 * - 1.9 문자열 회전
 * - 한 단어가 다른 문자열에 포함되어 있는지 판별하는 isSubstring이라는 메서드가 있다고 하자.
 * - s1과 s2의 두 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자 한다.
 * - (가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다)
 * - isSubstring 메서드를 한 번만 호출해서 판별할 수 있는 코드를 작성하라.
 */
public class one09
{
    
    // isSubString 이라는 메서드가 있으므로 어느 시점에서 isSubString을 호출할 건지 정하는 메서드를 작성하면 된다.
    boolean isRotation(String s1, String s2)
    {
        int len = s1.length();
        
        // s1과 s2의 길이가 같고 빈(empty) 문자열이 아닌지 확인한다.
        if (len == s2.length() && len > 0)
        {
            // s1과 s1을 합친 결과를 새로운 버퍼에 저장한다.
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }
    
    private boolean isSubString(String s1s1, String s2)
    {
        if (s1s1.contains(s2))
            return true;
        return false;
    }
}
