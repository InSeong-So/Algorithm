const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

class priority_queue {
  constructor(f) {
    this.compare = f;
    this.vec = [0, 0];
    this.limit = 2;
    this.len = 0;
  }

  push(value) {
    if (this.len + 1 == this.limit) {
      this.limit *= 2;
      this.vec.concat(this.vec);
    }

    this.len++;
    let idx = this.len;
    this.vec[idx] = value;

    while (
      idx > 1 &&
      this.compare(this.vec[parseInt(idx / 2)], this.vec[idx])
    ) {
      [this.vec[parseInt(idx / 2)], this.vec[idx]] = [
        this.vec[idx],
        this.vec[parseInt(idx / 2)],
      ];
      idx = parseInt(idx / 2);
    }
  }

  pop() {
    let result = this.vec[1];
    this.vec[1] = this.vec[this.len];
    this.len--;

    let idx = 1;
    while (true) {
      let next = idx;
      let left = idx * 2;
      let right = idx * 2 + 1;

      if (left <= this.len && this.compare(this.vec[next], this.vec[left]))
        next = left;
      if (right <= this.len && this.compare(this.vec[next], this.vec[right]))
        next = right;
      if (next == idx) break;

      [this.vec[idx], this.vec[next]] = [this.vec[next], this.vec[idx]];
      idx = next;
    }

    return result;
  }

  empty() {
    return this.len == 0;
  }
}

function compare(A, B) {
  if (A[0] < B[0]) return true;
  return false;
}

function solution() {
  let q = new priority_queue(compare);
  input = input.map(x => x.split(' ').map(y => parseInt(y)));

  let [vertex, edge] = input[0];
  input.shift();
  let start = input[0];

  let adj = new Array(vertex + 1);
  for (let i = 0; i <= vertex; i++) adj[i] = [];

  for (let i = 1; i <= edge; i++) {
    let [from, to, cost] = input[i];
    adj[from].push([to, cost]);
  }

  let dist = new Array(vertex + 1).fill(2147483647);
  dist[start] = 0;
  q.push([0, start]);

  while (!q.empty()) {
    let [cost, from] = q.pop();
    cost = -cost;
    if (dist[from] > cost) continue;

    for (let [to, b] of adj[from]) {
      let dis = b + cost;
      if (dis < dist[to]) {
        dist[to] = dis;
        q.push([-dis, to]);
      }
    }
  }

  let answer = '';
  for (let i = 1; i <= vertex; i++) {
    if (dist[i] == 2147483647) answer += 'INF\n';
    else answer += dist[i].toString() + '\n';
  }
  console.log(answer);
}

/**
 * ========================================================
 * @Title       : 1753
 * @Path        : javascript\02_Solved\boj\g.최단경로\01_1753.spec.js
 * @Link        : https://www.acmicpc.net/problem/1753
 * @Description : 최단경로
 * @Note        :
 * @Date        : 2021-08-10 10:51:27
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_1753', () => {
  // 테스트 케이스명
  it('기본1', () => {
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
    const graph = Array.from({ lengh: v + 1 }, () => Array());
    for (const [u, v, w] of arr) {
      graph[u].push([v, w]);
    }
    const consoleResult = jest.spyOn(console, 'log');
    console.log(solution(v, e, start, graph));
    const result = '0, 2, 3, 7, "INF"';

    // 테스트 결과 정의
    expect(consoleResult).toHaveBeenCalledWith(result);
  });
});
