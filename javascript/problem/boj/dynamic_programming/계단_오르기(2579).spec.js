/**
 * 입력
 */
const data = require('fs')
  .readFileSync('/dev/stdin', 'utf8')
  .toString()
  .trim()
  .split('\n');

const memo = [];
for (let i = 0; i < 301; i++) {
  memo.push([0, 0]);
}

const score = (n, stride) => {
  if (n <= 2) {
    return memo[n][stride];
  } else {
    if (memo[n][stride] === 0) {
      if (stride === 0) {
        memo[n][stride] = score(n - 1, 1) + Number(data[n]);
      } else if (stride === 1) {
        memo[n][stride] =
          Math.max(score(n - 2, 0), score(n - 2, 1)) + Number(data[n]);
      }
    }
    return memo[n][stride];
  }
};

const n = Number(data[0]);
memo[1][0] = Number(data[1]);
memo[1][1] = 0;
memo[2][0] = Math.max(memo[1][0], memo[1][1]) + Number(data[2]);
memo[2][1] = Number(data[2]);

console.log(Math.max(score(n, 0), score(n, 1)));

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 07_2579
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\07_2579.spec.js
 * @Link        : https://www.acmicpc.net/problem/2579
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:39:33
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('07_2579', () => {
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
