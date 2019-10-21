package practice.programmers.array;

import java.util.Arrays;

public class K번째수
{
    public int[] solution(int[] array, int[][] commands) {
        //정답용 배열 생성
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            //자른 배열 저장용 tmpArr 생성
            int[] tmpArr = new int[commands[i][1]-commands[i][0]+1];
            //tmpArr에 array 잘라서 저장
            int idx = 0;
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                tmpArr[idx] = array[j];
                idx++;
            }
            //자른 배열 정렬
            Arrays.sort(tmpArr);
            //정답 삽입
            answer[i] = tmpArr[commands[i][2]-1];
        }
        return answer;
    }
}
