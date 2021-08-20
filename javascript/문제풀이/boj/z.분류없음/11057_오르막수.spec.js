/**
 * 입력
 */
// const fs = require('fs');
// const N = Number(fs.readFileSync('dev/stdin').toString().trim());

// solution(input);

/**
 * Solve 함수
 */
const solution = N => {
  const dp = Array.from({ length: 10 }, () => Array(N + 1).fill(0));
  for (let i = 9; i >= 0; i--) {
    for (let j = 1; j <= N; j++) {
      if (j === 1) {
        dp[i][1] = 1;
      } else if (i === 9) {
        dp[9][j] = 1;
      } else {
        dp[i][j] = (dp[i][j - 1] + dp[i + 1][j]) % 10007;
      }
    }
  }

  let answer = 0;
  for (let i = 0; i < 10; i++) {
    answer += dp[i][N];
  }
  console.log(answer % 10007);
};

/**
 * ========================================================
 * @Title       : 11057
 * @Path        : javascript\문제풀이\boj\z.분류없음\11057_오르막수.spec.js
 * @Link        : https://www.acmicpc.net/problem/11057
 * @Description : 오르막 수
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-20 14:57:21
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('11057_오르막수', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 1;
    // 함수 실행
    solution(input);
    // 결과
    const result = 10;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 2;
    // 함수 실행
    solution(input);
    // 결과
    const result = 55;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 3;
    // 함수 실행
    solution(input);
    // 결과
    const result = 220;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
