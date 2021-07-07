/*=======================================================================================
[ 경로 탐색(인접행렬) ]
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하라.
아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5
총 6 가지이다.
=======================================================================================*/

// ▣ 입력설명
// 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

// ▣ 출력설명
// 총 가지수를 출력한다.

// ▣ 입력예제 1
// 5 9
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2
// 4 5

// ▣ 출력예제 1
// 6

function solution(n, arr) {
  let answer = 0;
  // 1부터 시작하므로n +1
  let graph = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
  let check = Array.from({ length: n + 1 }, () => 0);
  // let path = []; // 테스트용

  for (let [a, b] of arr) {
    graph[a][b] = 1;
  }

  function DFS(v, n) {
    if (v === n) {
      answer++;
    } else {
      for (let i = 1; i <= n; i++) {
        // 갈 수 있는 방향이고, 방문한 적이 없다면
        if (graph[v][i] === 1 && check[i] === 0) {
          // visited
          check[i] = 1;
          // path.push(i); // 테스트
          // 재귀
          DFS(i, n);
          // backtracking
          check[i] = 0;
          // path.pop(); // 테스트
        }
      }
    }
  }

  // path.push(1); // 테스트
  check[1] = 1; // 1번에서 시작하므로 무조건 방문했다고 표시를 해주어야 함
  DFS(1, n);

  return answer;
}

function solution2(n, arr) {
  let answer = 0;

  let graph = Array.from({ length: n + 1 }, () =>
    Array.from({ length: n + 1 }, () => 0),
  );
  let check = Array.from({ length: n + 1 }, () => 0);

  for (let [a, b] of arr) {
    graph[a][b] = 1;
  }

  function DFS(v, n) {
    if (v === n) {
      answer++;
    } else {
      for (let i = 1; i <= n; i++) {
        if (graph[v][i] === 1 && check[i] === 0) {
          check[i] = 1;
          DFS(i, n);
          check[i] = 0;
        }
      }
    }
  }

  check[1] = 1;
  DFS(1, n);

  return answer;
}

/**
 * ========================================================
 * @Title       : 01_경로탐색(DFS-인접행렬)
 * @Path        : javascript\02_Solved\inflearn\i.graph\01_경로탐색(DFS-인접행렬).spec.js
 * @Description : 그래프 자료구조 - DFS 알고리즘
 * @Date        : 2021-07-06 16:04:11
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_경로탐색(DFS-인접행렬)', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의

    let arr = [
      [1, 2],
      [1, 3],
      [1, 4],
      [2, 1],
      [2, 3],
      [2, 5],
      [3, 4],
      [4, 2],
      [4, 5],
    ];

    const result = 6;

    // 테스트 결과 정의
    expect(solution2(5, arr)).toEqual(result);
  });
});
