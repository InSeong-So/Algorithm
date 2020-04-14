import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 랜덤 난수/문자열 리스트/배열 생성
 * 테스트 케이스를 임의로 생성할 수 있는 메소드로 시간/공간 복잡도 체크용
 * 
 * @author 소인성
 * @date 2019-11-06
 */
public class CustomList
{
    private static Random rng = new Random();
    
    public static void main(String[] args)
    {
        // 중복 없는 랜덤 난수 배열 생성
        int[] n = randomIntArray();
        System.out.println("중복 없는 랜덤 난수 배열 출력 :");
        System.out.println(Arrays.toString(n));
        System.out.println();
        
        // 중복 없는 랜덤 난수 리스트 생성
        List<Integer> n2 = randomIntList();
        System.out.println("중복 없는 랜덤 난수 리스트 출력 :");
        System.out.println(n2.toString());
        System.out.println();
        
        // 중복 없는 랜덤 문자 배열 생성
        String[] s = randomStringArray();
        System.out.println("중복 없는 랜덤 문자 배열 출력 :");
        System.out.println(Arrays.toString(s));
        System.out.println();
        
        // 중복 없는 랜덤 문자 리스트 생성
        List<String> s2 = randomStringList();
        System.out.println("중복 없는 랜덤 문자 리스트 출력 :");
        System.out.println(s2.toString());
        System.out.println();
    }
    
    /**
     * 중복 없는 난수 리스트 생성
     * 
     * @param maxInt
     *            난수의 범위(예: maxInt = 5 일 때 1 ~ 5 사이의 난수 생성)
     * @param listSize
     *            난수 리스트의 원소 갯수(예: listSize = 5 일 때 5개의 난수를 담은 리스트 생성)
     * @return List<Integer>
     */
    public static List<Integer> randomIntList(int maxInt, int listSize)
    {
        if (maxInt < listSize)
            throw new IllegalArgumentException("숫자 범위의 갯수보다 리스트의 크기가 클 수 없습니다.");
        
        Set<Integer> generated = new LinkedHashSet<Integer>();
        
        while (generated.size() < listSize)
        {
            Integer next = rng.nextInt(maxInt) + 1;
            generated.add(next);
        }
        
        List<Integer> result = new ArrayList<Integer>(generated);
        
        return result;
    }
    
    /**
     * 중복 없는 난수 리스트 포워드
     * 
     * @default maxInt = 100, listSzie = 20;
     * @return List<Integer>
     */
    public static List<Integer> randomIntList()
    {
        return randomIntList(100, 20);
    }
    
    /**
     * 중복 없는 난수 배열 생성
     * 
     * @param maxInt
     *            난수의 범위(예: maxInt = 5 일 때 1 ~ 5 사이의 난수 생성)
     * @param arrSize
     *            난수 리스트의 원소 갯수(예: listSize = 5 일 때 5개의 난수를 담은 배열 생성)
     * @return
     */
    public static int[] randomIntArray(int maxInt, int arrSize)
    {
        if (maxInt < arrSize)
            throw new IllegalArgumentException("숫자 범위의 갯수보다 배열의 크기가 클 수 없습니다.");
        
        Set<Integer> generated = new LinkedHashSet<Integer>();
        
        while (generated.size() < arrSize)
        {
            Integer next = rng.nextInt(maxInt) + 1;
            generated.add(next);
        }
        
        int[] result = Arrays.stream(Arrays.copyOf(generated.toArray(), generated.size(), Integer[].class)).mapToInt(i -> i).toArray();
        
        return result;
    }
    
    /**
     * 중복 없는 난수 배열 포워드
     * 
     * @default maxInt = 100, listSzie = 20;
     * @return
     */
    public static int[] randomIntArray()
    {
        return randomIntArray(100, 20);
    }
    
    /**
     * 랜덤 문자 리스트 생성
     * 
     * @param listSize
     *            랜덤 문자 리스트의 원소 갯수(예: listSize = 5 일 때 5개의 난수를 담은 배열 생성)
     * @return
     */
    public static List<String> randomStringList(int listSize)
    {
        if (listSize < 1)
            throw new IllegalArgumentException("리스트의 크기는 1보다 작을 수 없습니다.");
        Set<String> generated = new LinkedHashSet<String>();
        
        StringBuffer sb = new StringBuffer();
        
        for (char ch = 'a'; ch <= 'z'; ch++)
            sb.append(ch);
        
        char[] chars = sb.toString().toCharArray();
        
        while (generated.size() < listSize)
        {
            sb.setLength(0);
            for (int i = 0; i < rng.nextInt(10); i++)
            {
                sb.append(chars[rng.nextInt(26)]);
            }
            generated.add(sb.toString());
        }
        
        List<String> result = new ArrayList<String>(generated);
        
        return result;
    }
    
    /**
     * 중복 없는 랜덤 문자 리스트 포워드
     * 
     * @default listSzie = 20;
     * @return
     */
    public static List<String> randomStringList()
    {
        return randomStringList(20);
    }
    
    /**
     * 중복 없는 랜덤 문자 배열 생성
     * 
     * @param arrSize
     *            랜덤 문자 배열의 원소 갯수(예: listSize = 5 일 때 5개의 난수를 담은 배열 생성)
     * @return
     */
    public static String[] randomStringArray(int arrSize)
    {
        if (arrSize < 1)
            throw new IllegalArgumentException("배열의 크기는 1보다 작을 수 없습니다.");
        
        Set<String> generated = new LinkedHashSet<String>();
        
        StringBuffer sb = new StringBuffer();
        
        for (char ch = 'a'; ch <= 'z'; ch++)
            sb.append(ch);
        
        char[] chars = sb.toString().toCharArray();
        
        while (generated.size() < arrSize)
        {
            sb.setLength(0);
            for (int i = 0; i < rng.nextInt(10); i++)
            {
                sb.append(chars[rng.nextInt(26)]);
            }
            generated.add(sb.toString());
        }
        
        String[] result = generated.toArray(new String[generated.size()]);
        
        return result;
    }
    
    /**
     * 중복 없는 랜덤 문자 배열 포워드
     * 
     * @default arrSzie = 20;
     * @return
     */
    public static String[] randomStringArray()
    {
        return randomStringArray(20);
    }
}
