// 문제 : https://programmers.co.kr/learn/courses/30/lessons/49189

/* BFS를 활용하여 해결한다. */
function solution(n, edge) {
  let answer = 0;

  const graph = Array(n + 1)
    .fill(0)
    .map(x => []);

  for (let e of edge) {
    graph[e[0]].push(e[1]);
    graph[e[1]].push(e[0]);
  }

  let queue = [];
  let visited = Array(n + 1).fill(false);
  let min = Array(n + 1).fill(Infinity);
  // 1번 정점에서 시작
  queue.push(1);
  // 1번 방문 체크
  visited[1] = true;
  min[0] = 0;
  min[1] = 0;
  while (queue.length) {
    let v = queue.shift();
    for (let i = 0; i < graph[v].length; i++) {
      let next = graph[v][i];
      if (!visited[next]) {
        queue.push(next);
        visited[next] = true;
      }

      if (min[next] > min[v] + 1) {
        min[next] = min[v] + 1;
      }
    }
  }
  let longer = Math.max(...min);
  return min.filter(x => x === longer).length;
}

// 다른 풀이
/*
BFS: V+E (un-weighted, 1:M)

Dijkstra: (V + E)logV (with priority queue), or V^2 (array; can be faster than heap) (non-negative, 1:M)

Bellman-ford: EV, or V^3 (non-negative-cycle, 1:M)

Floyd-warshall: V^3 (non-negative-cycle, M:M)
*/
function solution2(n, edges) {
  // make adjacent list
  const adjList = edges.reduce((G, [from, to]) => {
    G[from] = (G[from] || []).concat(to);
    G[to] = (G[to] || []).concat(from);
    return G;
  }, {});

  // do BFS
  const queue = [1];
  const visited = { 1: true };
  const dist = { 1: 0 };
  while (queue.length > 0) {
    const node = queue.shift();

    if (adjList[node]) {
      adjList[node].forEach(n => {
        if (!visited[n]) {
          queue.push(n);
          visited[n] = true;
          const d = dist[node] + 1;
          if (dist[n] == undefined || d < dist[n]) {
            dist[n] = d;
          }
        }
      });
    }
  }

  const dists = Object.values(dist);
  const maxDist = Math.max(...dists);
  return dists.filter(d => d == maxDist).length;
}

/**
 * ========================================================
 * @Title       : 가장_먼_노드
 * @Path        : javascript\02_Solved\programmers\가장_먼_노드.spec.js
 * @Description : 그래프 알고리즘
 * @Date        : 2021-07-12 00:09:04
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('가장_먼_노드', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let n = 6;
    let vertex = [
      [3, 6],
      [4, 3],
      [3, 2],
      [1, 3],
      [1, 2],
      [2, 4],
      [5, 2],
    ];
    const result = 3;

    // 테스트 결과 정의
    expect(solution(n, vertex)).toEqual(result);
  });
});
