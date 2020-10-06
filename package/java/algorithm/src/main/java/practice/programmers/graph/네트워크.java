package practice.programmers.graph;

public class 네트워크
{
    public int solution(int n, int[][] computers)
    {
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화
        
        for (int i = 0; i < n; i++)
        {
            if (!check[i])
            {
                dfs(computers, i, check);
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean[] dfs(int[][] computers, int i, boolean[] check)
    {
        check[i] = true;
        
        for (int j = 0; j < computers.length; j++)
        {
            if (i != j && computers[i][j] == 1 && check[j] == false)
            {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}
