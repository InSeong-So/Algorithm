// 인접 행렬로 그래프 구현
class Graph {
    private int[][] Graph;

    // 그래프 초기화
    public Graph(int initSize) {
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // 배열의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해
        // 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌
        this.Graph = new int[initSize + 1][initSize + 1];
    }

    // 그래프 return
    public int[][] getGraph() {
        return this.Graph;
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        Graph[x][y] = Graph[y][x] = 1;
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        Graph[x][y] = 1;
    }

    // 그래프 출력 (인접행렬)
    public void printGraphToAdjArr() {
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[i].length; j++) {
                System.out.print(" " + Graph[i][j]);
            }
            System.out.println();
        }
    }

    // 그래프 추가 (양방향 가중치) : 인접 행렬에 가중치(weight)를 추가할 경우
    // 간선이 존재하는 행렬에 1 대신 가중치 값을 설정한다.
    public void put(int x, int y, int w) {
        // 1 대신 가중치 값 w(weight)를 설정
        Graph[x][y] = Graph[y][x] = w;
    }
}

public class AdjacencyArray {
    public static void main(String[] args) {
        int initSize = 6;
        Graph adjArr = new Graph(initSize);
        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);
        adjArr.printGraphToAdjArr();
    }
}