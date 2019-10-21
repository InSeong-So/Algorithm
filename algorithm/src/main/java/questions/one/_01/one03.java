package questions.one._01;

import java.util.Arrays;

/*
 * - 1.3 URI화
 * - 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를 작성하라.
 * - 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있다.
 * - 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 * - (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열(character array)를 이용하길 바란다)
 */
public class one03
{
    
    char[] replaceSpaces(String str, int trueLength)
    {
        int spaceCount = 0, index, i = 0;
        char[] cstr = str.toCharArray();
        
        for (i = 0; i < trueLength; i++)
        {
            if (cstr[i] == ' ')
                spaceCount++;
        }
        
        index = trueLength + spaceCount * 2;
        char[] array = Arrays.copyOf(cstr, index);
        
        if (trueLength < cstr.length)
            array[trueLength] = '\0'; // 배열의 끝
            
        for (i = trueLength - 1; i >= 0; i--)
        {
            if (array[i] == ' ')
            {
                array[index - 1] = '0';
                array[index - 2] = '2';
                array[index - 3] = '%';
                index = index - 3;
            }
            else
            {
                array[index - 1] = array[i];
                index--;
            }
        }
        
        return array;
    }
}
