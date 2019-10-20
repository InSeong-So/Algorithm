package questions.one._01;

/*
 * - 1.4 회문 순열
 * - 주어진 문자열이 회문(palindrome)의 순열인지 아닌지 확인하는 함수를 작성하라.
 * - 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미한다.
 * - 순열이란 문자열을 재배치하는 것을 뜻한다.
 * - 회문이 꼭 사전에 등장하는 단어로 제한될 필요는 없다.
 */
public class one04
{
    
    // ASCII A(65) - Z(90), a(97) - z(122)
    
    // solution 1. Time Complexity O(n)
    // solution 1.0
    boolean isPermutationOfPalindrome(String phrase)
    {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }
    
    // solution 1.1
    // 홀수 문자가 한 개 이상 존재하는지 확인한다.
    private boolean checkMaxOneOdd(int[] table)
    {
        boolean foundOdd = false;
        for (int count : table)
        {
            if (count % 2 == 1)
            {
                if (foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }
    
    // solution 1.2
    // 각 문자가 몇 번 등장했는지 센다.
    private int[] buildCharFrequencyTable(String phrase)
    {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        
        for (char c : phrase.toCharArray())
        {
            int x = getCharNumber(c);
            if (x != -1)
                table[x]++;
        }
        return table;
    }
    
    // solution 1.3
    // 각 문자에 숫자를 대응시킨다. a -> 0, b -> 1, c -> 2, 등등.
    // 대소문자 구분이 없고, 문자가 아닌 경우에는 -1로 대응시킨다.
    private int getCharNumber(Character c)
    {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z)
            return val - a;
        return -1;
    }
    
    /************************************************************************/
    
    // solution 2. Time Complexity O(n)
    boolean isPermutationOfPalindrome2(String phrase)
    {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray())
        {
            int x = getCharNumber(c);
            if (x != -1)
            {
                table[x]++;
                
                if (table[x] % 2 == 1)
                {
                    countOdd++;
                }
                else
                {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
    
    /************************************************************************/
    
    // solution 3. Time Complexity O(n)
    // vector 연산
    // solution 3.0
    boolean isPermutationOfPalindrome3(String phrase)
    {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }
    
    // solution 3.1
    // 문자열에 대한 비트 벡터를 만든다. 값이 i인 문자가 등장하면 i번째 비트값을 바꾼다.
    private int createBitVector(String phrase)
    {
        int bitVector = 0;
        for (char c : phrase.toCharArray())
        {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }
    
    // 정수의 i번째 비트값을 바꾼다.
    // solution 3.2
    private int toggle(int bitVector, int index)
    {
        if (index < 0)
            return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0)
        {
            bitVector |= mask;
        }
        else
        {
            bitVector &= ~mask;
        }
        return bitVector;
    }
    
    // 정확히 비트 한 개만 1로 세팅됐는지 확인하기 위해 주어진 정수값에서 1을 뺀 뒤
    // 원래 값과 AND 연산을 한다.
    // solution 3.3
    private boolean checkExactlyOneBitSet(int bitVector)
    {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
