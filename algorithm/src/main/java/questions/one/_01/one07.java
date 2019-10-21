package questions.one._01;

/*
 * - 1.7 행렬 회전
 * - 이미지를 표현하는 N x N 행렬이 있다.
 * - 이미지의 각 픽셀은 4바이트로 표현된다.
 * - 이 때, 이미지를 90도 회전시키는 메서드를 작성하라.
 * - 행렬을 추가로 사용하지 않고서도 할 수 있겠는가?
 */
public class one07
{
    
    // Time Complexity O(N^2)
    // 적어도 N^2 개의 원소를 모두 건드려 봐야 하므로 최선의 방법임
    boolean rotate(int[][] matrix)
    {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;
        
        int n = matrix.length;
        
        for (int layer = 0; layer < n / 2; layer++)
        {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++)
            {
                int offset = i - first;
                int top = matrix[first][i]; // 윗 부분을 저장
                
                // 왼쪽 -> 위쪽
                matrix[first][i] = matrix[last - offset][first];
                
                // 아래쪽 -> 왼쪽
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // 오른쪽 -> 아래쪽
                matrix[last][last - offset] = matrix[i][last];
                
                // 위쪽 -> 오른쪽
                matrix[i][last] = top; // 오른쪽 <- 미리 저장해 놓은 top
            }
        }
        return true;
    }
}
