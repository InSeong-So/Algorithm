/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄
// let input = fs.readFileSync('/dev/stdin').toString().split(os.EOL); // 다른 방식

/**
 * Solve 함수
 */
function solution(N, input) {
  const dp = Array.from({ length: N + 1 }, () => Array(3).fill(0));
  dp[0][0] = input[0][0];
  dp[0][1] = input[0][1];
  dp[0][2] = input[0][2];
  for (let i = 1; i < N; i++) {
    dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + parseInt(input[i][0]);
    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + parseInt(input[i][1]);
    dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + parseInt(input[i][2]);
  }
  return Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 05_1149
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\05_1149.spec.js
 * @Link        : https://www.acmicpc.net/problem/05_1149
 * @Description : RGB거리
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 15:58:17
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('05_1149', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 3;
    const input = [
      [26, 40, 83],
      [49, 60, 57],
      [13, 89, 99],
    ];
    // 함수 실행
    console.log(solution(N, input));
    // 결과
    const result = 96;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
