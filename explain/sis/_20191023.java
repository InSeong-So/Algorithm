import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1회차 문제풀이
 * 
 * @author 소인성
 * @date 2019-10-23
 */
public class _20191023
{
    public static void main(String[] args)
    {
        // 함수 호출
    }
    
    /**
     * 1번 문제
     * 
     * @param str
     * @return
     */
    public static boolean solution1(String str)
    {
        if (str.length() > 128)
            return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++)
        {
            int val = str.charAt(i);
            if (char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }
    
    /**
     * 2번 문제
     * 
     * @param str
     * @param trueLength
     * @return
     */
    public static char[] solution2(String str, int trueLength)
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
    
    /**
     * 3번 문제
     * 
     * @param array
     * @param commands
     * @return
     */
    public static int[] solution3(int[] array, int[][] commands)
    {
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < commands.length; i++){
            System.out.println("시작");
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                if(commands[i][0] == commands[i][1]){
                    list.add(array[j-1]);
                    break;
                }
                list.add(array[j-1]);
            }

            Collections.sort(list);
            answer[i] = list.get((commands[i][2])-1);
            list.clear();
        }
        
        return answer;
    }
    
    /**
     * 4번 문제
     * 
     * @param n
     * @throws IOException
     */
    public static void solution4(int[] n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // or Scanner sc = new Scanner(System.in);
        
        String[] nums;
        // or String[] nums2;
        
        nums = br.readLine().split(" ");
        // or nums2 = sc.nextLine().split(" ");
        
        for (int i = 0; i < n.length; i++)
            n[i] = Integer.parseInt(nums[i]);
        // or n[i] = Integer.parseInt(nums2[i]);
        
        int tmp = 0;
        
        for (int i = 0; i < n.length - 1; i++)
        {
            for (int j = 0; j < n.length - 1; j++)
            {
                if (n[j] > n[j + 1])
                {
                    tmp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = tmp;
                    for (int p : n)
                        System.out.print(p + " ");
                    System.out.println();
                }
            }
        }
    }
    
}
