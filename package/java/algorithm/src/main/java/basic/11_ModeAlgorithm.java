import com.sun.org.apache.bcel.internal.generic.IndexedInstruction;

//[?] 주어진 데이터에서 가장 많이 나타난(중복된) 값
/**
 * 최빈값 알고리즘(Mode Algorithm): 점수 인덱스(0~100)의 개수(COUNT)의 최댓값(MAX)
 */
public class ModeAlgorithm {

    public static void main(String[] args) {
        //[1] Input
        int[] scores = { 1, 3, 4, 3, 5 }; // 0~5까지만 들어온다고 가정 
        int[] indexes = new int[5 + 1]; // 0~5까지: 점수 인덱스의 카운터
        int max = Integer.MIN_VALUE; // MAX
        int mode = 0; // 최빈값이 담길 그릇

        //[2] Process
        for (int i = 0; i < scores.length; i++)
        {
            indexes[scores[i]]++; // COUNT
        }
        for (int i = 0; i < indexes.length; i++)
        {
            if (indexes[i] > max)            
            {
                max = indexes[i]; // MAX
                mode = i; // MODE
            }
        }

        //[3] Output
        System.out.println("최빈값: " + mode + " - " + max + "번");
    }
}
