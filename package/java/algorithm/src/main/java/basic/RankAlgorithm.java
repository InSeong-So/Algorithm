package basic;

public class RankAlgorithm
{
    public static void main(String[] args)
    {
        // Input
        int[] scores = { 90, 87, 100, 95, 80 }; // 등수 : 3, 4, 1, 2, 5
        int[] rankings = { 1, 1, 1, 1, 1 }; // 모두 1로 초기화
        
        // Process
        for (int i = 0; i < scores.length; i++)
        {
            rankings[i] = 1; // 순위 배열을 매 순회마다 1등으로 초기화
            for (int j = 0; j < scores.length; j++)
            {
                // 현재 i와 나머지 j 비교
                if (scores[i] < scores[j])
                {
                    // 자신보다 큰 점수가 나오면 순위 1 증가
                    rankings[i]++;
                }
            }
        }
        
        // Output
        for (int i = 0; i < scores.length; i++)
        {
            System.out.println(String.format("%3d점: %1d등", scores[i], rankings[i]));
        }
    }
}
