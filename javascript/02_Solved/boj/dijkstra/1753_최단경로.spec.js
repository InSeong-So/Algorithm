// https://www.acmicpc.net/problem/1753 문제의 입력을 수정한 내용입니다.

/*
[문제]
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
단, 모든 간선의 가중치는 10 이하의 자연수이다.

[입력]
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
(1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다.
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

[출력]
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
*/

import PriorityQueue from '../../../01_Snippet/structure/PriorityQueue';

function solution(v, e, start, arr) {
  let queue = new PriorityQueue();
  let answer = Array(v + 1).fill(0);
  let graph = Array.from({ length: v + 1 }, () => Array(v + 1).fill(Infinity));
  let check = Array(v + 1).fill(0);

  return answer;
}

/**
 * ========================================================
 * @Title       : 1753_최단경로
 * @Path        : javascript\02_Solved\boj\dijkstra\1753_최단경로.spec.js
 * @Description :
 * @Date        : 2021-07-08 17:11:37
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('1753_최단경로', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let v = 5;
    let e = 6;
    let start = 1;
    let arr = [
      [5, 1, 1],
      [1, 2, 2],
      [1, 3, 3],
      [2, 3, 4],
      [2, 4, 5],
      [3, 4, 6],
    ];
    // const result = [0, 2, 3, 7, 'INF'];
    const result = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

    // 테스트 결과 정의
    expect(solution(v, e, start, arr)).toEqual(result);
  });
});
