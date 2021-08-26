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
