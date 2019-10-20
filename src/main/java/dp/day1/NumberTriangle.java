package dp.day1;

import java.util.Scanner;

public class NumberTriangle
{
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int[][] inputArray = new int[index][index];
        int[][] outputArray = new int[index][index];
        
        // 삼각형 만들기
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                inputArray[i][j] = sc.nextInt();
            }
        }
        
        /*
         * 7
         * 3 8
         * 8 1 0
         * 2 7 4 4
         * 4 5 2 6 5
         */
        
        /*
         * [0][0]
         * [1][0] [1][1]
         * [2][0] [2][1] [2][2]
         * [3][0] [3][1] [3][2] [3][3]
         * [4][0] [4][1] [4][2] [4][3] [4][4]
         */
        
        // 첫번째 줄의 값으로 초기화
        outputArray[0][0] = inputArray[0][0];
        
        // 각 줄의 합을 계산
        // 첫번째 값을 넣었으니 배열의 인덱스(줄)는 0이 아닌 1부터 시작
        for (int i = 1; i < index; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                // 이전에 더한 값과 입력받은 삼각형의 값을 더한 후 최종 더한 값에 저장
                outputArray[i][j] = outputArray[i - 1][j] + inputArray[i][j];
                if (j - 1 >= 0 && outputArray[i][j] < outputArray[i - 1][j - 1] + inputArray[i][j])
                {
                    outputArray[i][j] = outputArray[i - 1][j - 1] + inputArray[i][j];
                }
            }
        }
        
        // 최종값 비교
        int result = outputArray[index - 1][0];
        for (int i = 0; i < index; i++)
        {
            if (result < outputArray[index - 1][i])
            {
                result = outputArray[index - 1][i];
            }
        }
        System.out.println(result);
        
    }
}
