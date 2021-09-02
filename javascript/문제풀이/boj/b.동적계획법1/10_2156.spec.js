/**
 * 입력
 */
const fs = require('fs');
let [n, ...wines] = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(Number);
wines = [0].concat(wines);

const dp = new Array(n + 1).fill(0);

dp[1] = wines[1];
dp[2] = dp[1] + wines[2];

for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(
    dp[i - 2] + wines[i],
    dp[i - 3] + wines[i - 1] + wines[i],
    dp[i - 1],
  );
}

console.log(dp[n]);

/**
 * ========================================================
 * @Title       : 10_2156
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\10_2156.spec.js
 * @Link        : https://www.acmicpc.net/problem/10_2156
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:43:49
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('10_2156', () => {
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
