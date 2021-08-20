/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
// const vertex = Number(input[0]);
// const graph = Array.from({ length: vertex + 1 }, () => Array());
// input.slice(1).map(e => {
//   const [vertex, ...next] = e.split(' ').map(Number);
//   for (let i = 0; i < next.length - 1; i += 2) {
//     graph[vertex].push([next[i], next[i + 1]]);
//   }
// });
// solution(vertex, graph);

/**
 * Solve 함수
 */
function solution(vertex, graph) {
  const BFS = v => {
    const distance = Array.from({ length: vertex + 1 }, () => -1);
    let queue = [[0, v]];
    distance[v] = 0;
    let maxDistacne = 0;
    let distanceIndex = 0;
    while (queue.length > 0) {
      const [lw, lv] = queue.shift();
      for (let [nv, w] of graph[lv]) {
        const nw = w + lw;
        if (distance[nv] === -1) {
          distance[nv] = Math.max(nw, distance[lv]);
          queue.push([nw, nv]);
          if (maxDistacne < nw) {
            maxDistacne = nw;
            distanceIndex = nv;
          }
        }
      }
    }

    return [distanceIndex, maxDistacne];
  };

  const [v, w] = BFS(1);
  const [lv, lw] = BFS(v);
  console.log(Math.max(w, lw));
}

/**
 * ========================================================
 * @Title       : 1167
 * @Path        : javascript\문제풀이\boj\z.분류없음\1167_트리의지름.spec.js
 * @Link        : https://www.acmicpc.net/problem/1167
 * @Description : 트리의 지름
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-18 10:02:08
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('1167_트리의지름', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [
      '5',
      '1 3 2 -1',
      '2 4 4 -1',
      '3 1 2 4 3 -1',
      '4 2 4 3 3 5 6 -1',
      '5 4 6 -1',
    ];
    const vertex = Number(input[0]);
    const graph = Array.from({ length: vertex + 1 }, () => Array());
    input.slice(1).map(e => {
      const [vertex, ...next] = e.split(' ').map(Number);
      for (let i = 0; i < next.length - 1; i += 2) {
        graph[vertex].push([next[i], next[i + 1]]);
      }
    });

    // 함수 실행
    solution(vertex, graph);
    // 결과
    const result = 11;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('반례1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [
      '12',
      '1 2 1 6 1 10 1 -1',
      '2 1 1 3 1 -1',
      '3 2 1 4 1 -1',
      '4 3 1 5 1 -1',
      '5 4 1 -1',
      '6 1 1 7 1 -1',
      '7 6 1 8 1 -1',
      '8 7 1 9 1 -1',
      '9 8 1 -1',
      '10 1 1 11 1 12 1 -1',
      '11 10 1 -1',
      '12 10 1 -1',
    ];
    const vertex = Number(input[0]);
    const graph = Array.from({ length: vertex + 1 }, () => Array());
    input.slice(1).map(e => {
      const [vertex, ...next] = e.split(' ').map(Number);
      for (let i = 0; i < next.length - 1; i += 2) {
        graph[vertex].push([next[i], next[i + 1]]);
      }
    });

    // 함수 실행
    solution(vertex, graph);
    // 결과
    const result = 8;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});

// 다른 풀이, 이게 훨씬 빠름
const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const V = Number(input[0]);
const node = new Array(V);
const visited = new Array(V);
let result = 0;
let newPoint = 1;

for (let i = 0; i < V + 1; i++) {
  node[i] = new Array();
  visited[i] = false;
}

for (let i = 0; i < V; i++) {
  const arr = input[i + 1].split(' ').map(e => Number(e));
  for (let j = 0; j < arr.length / 2 - 1; j++) {
    node[arr[0]].push([arr[j * 2 + 1], arr[j * 2 + 2]]);
  }
}

const dfs = (point, len) => {
  const stack = [];
  stack.push([point, len]);

  while (stack.length) {
    const now = stack.pop();

    if (visited[now[0]]) {
      continue;
    }

    visited[now[0]] = true;

    if (result < now[1]) {
      result = now[1];
      newPoint = now[0];
    }

    for (let i = 0; i < node[now[0]].length; i++) {
      stack.push([node[now[0]][i][0], now[1] + node[now[0]][i][1]]);
    }
  }
};

dfs(1, 0);
for (let i = 0; i < V + 1; i++) {
  visited[i] = false;
}

dfs(newPoint, 0);
console.log(result);
