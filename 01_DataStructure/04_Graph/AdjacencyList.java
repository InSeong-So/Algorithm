import java.util.ArrayList;

// 인접 리스트로 그래프 구현
class Graph {
    private ArrayList<ArrayList<Integer>> Graph;

    // 그래프 초기화
    public Graph(int initSize) {
        this.Graph = new ArrayList<ArrayList<Integer>>();
        // 그래프 생성
        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // ArrayList의 index는 0 부터 시작이므로
        // ArrayIndexOutOfBoundsException 방지를 위해
        // 정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
        // ex) initSize = 3
        // graph[0]
        // graph[1] -> 2 -> 3
        // graph[2] -> 1 -> 3 -> 4
        // graph[3] -> 1 -> 2 -> 4 -> 5
        for (int i = 0; i < initSize + 1; i++) {
            Graph.add(new ArrayList<Integer>());
        }
    }

    // 그래프 return
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.Graph;
    }

    // 그래프의 특정 노드 return
    public ArrayList<Integer> getNode(int i) {
        return this.Graph.get(i);
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        Graph.get(x).add(y);
        Graph.get(y).add(x);
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        Graph.get(x).add(y);
    }

    // 그래프 출력 (인접리스트)
    public void printGraphToAdjList() {
        for (int i = 1; i < Graph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            for (int j = 0; j < Graph.get(i).size(); j++) {
                System.out.print(" -> " + Graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}

public class AdjacencyList {
    public static void main(String[] args) {
        int initSize = 6;
        Graph adjList = new Graph(initSize);
        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 3);
        adjList.put(2, 4);
        adjList.put(3, 4);
        adjList.put(3, 5);
        adjList.put(4, 5);
        adjList.put(4, 6);
        adjList.printGraphToAdjList();
    }
}