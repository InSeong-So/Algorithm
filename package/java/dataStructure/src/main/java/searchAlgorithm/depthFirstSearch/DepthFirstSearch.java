package searchAlgorithm.depthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
	private int V;   // 노드의 개수
	private LinkedList<Integer> adj[]; // 인접 리스트

	/** 생성자 */
	DepthFirstSearch(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) // 인접 리스트 초기화
			adj[i] = new LinkedList();
	}

	/** 노드를 연결 v->w */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/** DFS에 의해 사용되는 함수 */
	void DFSUtil(int v, boolean visited[]) {
		// 현재 노드를 방문한 것으로 표시하고 값을 출력
		visited[v] = true;
		System.out.print(v + " ");

		// 방문한 노드와 인접한 모든 노드를 가져온다.
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			// 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
			if (!visited[n])
				DFSUtil(n, visited); // 순환 호출
		}
	}

	/** 주어진 노드를 시작 노드로 DFS 탐색 */
	void DFS(int v) {
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];

		// v를 시작 노드로 DFSUtil 순환 호출
		DFSUtil(v, visited);
	}

	/** DFS 탐색 */
	void DFS() {
		// 노드의 방문 여부 판단 (초깃값: false)
		boolean visited[] = new boolean[V];

		// 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
		for (int i = 0; i < V; ++i) {
			if (visited[i] == false)
				DFSUtil(i, visited);
		}
	}
}
