package codingTest.kakao;

public class _2020_05
{
    /*
     * [문제설명]
     * 빙하가 깨지면서 스노우타운에 떠내려 온 “죠르디”는 인생 2막을 위해 주택 건축사업에 뛰어들기로 결심하였습니다. “죠르디”는 기둥과
     * 보를 이용하여 벽면 구조물을 자동으로 세우는 로봇을 개발할 계획인데, 그에 앞서 로봇의 동작을 시뮬레이션 할 수 있는 프로그램을
     * 만들고 있습니다. 프로그램은 2차원 가상 벽면에 기둥과 보를 이용한 구조물을 설치할 수 있는데, 기둥과 보는 길이가 1인 선분으로
     * 표현되며 다음과 같은 규칙을 가지고 있습니다.
     * 
     * 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
     * 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
     * 단, 바닥은 벽면의 맨 아래 지면을 말합니다.
     * 
     * 2차원 벽면은 n x n 크기 정사각 격자 형태이며, 각 격자는 1 x 1 크기입니다. 맨 처음 벽면은 비어있는 상태입니다. 기둥과
     * 보는 격자선의 교차점에 걸치지 않고, 격자 칸의 각 변에 정확히 일치하도록 설치할 수 있습니다. 다음은 기둥과 보를 설치해 구조물을
     * 만든 예시입니다.
     * 
     * 예를 들어, 위 그림은 다음 순서에 따라 구조물을 만들었습니다.
     * 
     * (1, 0)에서 위쪽으로 기둥을 하나 설치 후, (1, 1)에서 오른쪽으로 보를 하나 만듭니다.
     * (2, 1)에서 위쪽으로 기둥을 하나 설치 후, (2, 2)에서 오른쪽으로 보를 하나 만듭니다.
     * (5, 0)에서 위쪽으로 기둥을 하나 설치 후, (5, 1)에서 위쪽으로 기둥을 하나 더 설치합니다.
     * (4, 2)에서 오른쪽으로 보를 설치 후, (3, 2)에서 오른쪽으로 보를 설치합니다.
     * 만약 (4, 2)에서 오른쪽으로 보를 먼저 설치하지 않고, (3, 2)에서 오른쪽으로 보를 설치하려 한다면 2번 규칙에 맞지
     * 않으므로 설치가 되지 않습니다. 기둥과 보를 삭제하는 기능도 있는데 기둥과 보를 삭제한 후에 남은 기둥과 보들 또한 위 규칙을
     * 만족해야 합니다. 만약, 작업을 수행한 결과가 조건을 만족하지 않는다면 해당 작업은 무시됩니다.
     * 
     * 벽면의 크기 n, 기둥과 보를 설치하거나 삭제하는 작업이 순서대로 담긴 2차원 배열 build_frame이 매개변수로 주어질 때,
     * 모든 명령어를 수행한 후 구조물의 상태를 return 하도록 solution 함수를 완성해주세요.
     * 
     */
    
    /*
     * [입출력 예]
     * 5
     * [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3
     * ,2,1,1]]
     * [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
     * 5
     * [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2
     * ,0,0,0],[1,1,1,0],[2,2,0,1]]
     * [[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
     */
    
    /*
     * [입출력 예에 대한 설명]
     * 입출력 예 #1 문제의 예시와 같습니다.
     * 입출력 예 #2 여덟 번째 작업을 수행 후 아래와 같은 구조물이 만들어집니다. 아홉 번째 작업의 경우, (1, 1)에서 오른쪽에
     * 있는 보를 삭제하면 (2, 1)에서 오른쪽에 있는 보는 조건을 만족하지 않으므로 무시됩니다.열 번째 작업의 경우, (2, 2)에서
     * 위쪽 방향으로 기둥을 세울 경우 조건을 만족하지 않으므로 무시됩니다.
     */
    
    boolean[][] pillars = new boolean[103][103];
    
    boolean[][] boards = new boolean[103][103];
    
    int N;
    
    public int[][] solution(int n, int[][] build_frame)
    {
        int[][] answer = {};
        N = n;
        int cnt = 0;
        for (int i = 0; i < build_frame.length; i++)
        {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            if (b == 1)
            { //설치
                if (a == 0 && buildPillar(x, y))
                { //기둥
                    pillars[x][y] = true;
                    cnt++;
                }
                else if (a == 1 && buildBoard(x, y))
                { //보
                    boards[x][y] = true;
                    cnt++;
                }
            }
            else
            { //삭제
                if (remove(x, y, a))
                    cnt--;
            }
        }
        
        answer = new int[cnt][3];
        int idx = 0;
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (pillars[i][j])
                {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 0;
                    idx++;
                }
                if (boards[i][j])
                {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }
        return answer;
    }
    
    boolean buildPillar(int x, int y)
    {
        if (y == 0)
            return true;
        if (pillars[x][y - 1])
            return true;
        if (boards[x][y])
            return true;
        if (x > 0 && boards[x - 1][y])
            return true;
        return false;
    }
    
    boolean buildBoard(int x, int y)
    {
        if (pillars[x][y - 1])
            return true;
        if (pillars[x + 1][y - 1])
            return true;
        if (x > 0 && boards[x - 1][y] && boards[x + 1][y])
            return true;
        return false;
    }
    
    boolean remove(int x, int y, int type)
    {
        boolean flag = true;
        if (type == 0)
        {
            pillars[x][y] = false;
        }
        else
        {
            boards[x][y] = false;
        }
        
        for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j <= N; j++)
            {
                if (pillars[i][j])
                {
                    pillars[i][j] = false;
                    if (!buildPillar(i, j))
                        flag = false;
                    pillars[i][j] = true;
                }
                if (boards[i][j])
                {
                    boards[i][j] = false;
                    if (!buildBoard(i, j))
                        flag = false;
                    boards[i][j] = true;
                }
            }
        }
        if (!flag)
        {
            if (type == 0)
            {
                pillars[x][y] = true;
            }
            else
            {
                boards[x][y] = true;
            }
        }
        return flag;
    }
}
