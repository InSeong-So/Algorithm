/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄
// let input = fs.readFileSync('/dev/stdin').toString().split(os.EOL); // 다른 방식

// solution(input);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 14889_스타트와링크
 * @Path        : javascript\문제풀이\boj\z.분류없음\14889_스타트와링크.spec.js
 * @Link        : https://www.acmicpc.net/problem/14889_스타트와링크
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-26 11:20:57
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('14889_스타트와링크', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = '';
    // 함수 실행
    solution(input);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});

// s
const fs = require('fs');
const os = require('os');
const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
const N = +input[0];
const matrix = input.slice(1).map(e => e.split(' ').map(e2 => +e2));
const visited = Array.from({ length: N + 1 }, () => 0);
let answer = Infinity;
const DFS = (teamCnt, next, N) => {
  if (teamCnt === +(N / 2)) {
    let start = 0;
    let link = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (visited[i] && visited[j]) {
          start += matrix[i][j];
        }
        if (!visited[i] && !visited[j]) {
          link += matrix[i][j];
        }
      }
    }
    answer = Math.min(Math.abs(start - link), answer);
    return;
  }

  // 백트래킹
  for (let i = next; i < N; i++) {
    visited[i] = 1;
    DFS(teamCnt + 1, i + 1, N);
    visited[i] = 0;
  }
};

DFS(0, 1, N);

console.log(answer);


//
let ip = (require('fs').readFileSync('dev/stdin', 'utf-8') + '')
  .trim()
  .split('\n');
let n = +ip[0],
  matrix = ip.slice(1).map(e => e.split(' ').map(e => +e)),
  t = [0],
  min = Infinity;

dfs(n / 2 - 1, 1);
console.log(min);

function dfs(left, st) {
  if (!left) {
    let df = getdf();
    if (min > df) min = df;
  }
  for (let i = st; i < n; i++) {
    t.push(i);
    dfs(left - 1, i + 1);
    t.pop();
  }
}
function getdf() {
  let v = [];
  for (let i = 1; i < n; i++) {
    if (!t.includes(i)) {
      v.push(i);
    }
  }
  let sum1 = 0,
    sum2 = 0;
  console.log(t, v);
  for (let i = 0; i < t.length; i++)
    for (let j = i + 1; j < t.length; j++) {
      sum1 += matrix[t[i]][t[j]] + matrix[t[j]][t[i]];
    }

  for (let i = 0; i < v.length; i++)
    for (let j = i + 1; j < v.length; j++) {
      sum2 += matrix[v[i]][v[j]] + matrix[v[j]][v[i]];
    }

  return Math.abs(sum1 - sum2);
}
