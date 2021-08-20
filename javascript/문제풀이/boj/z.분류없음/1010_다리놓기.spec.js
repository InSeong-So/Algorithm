/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
// const cases = input.slice(1).map(e => {
//   return e.split(' ').map(e2 => Number(e2));
// });

/**
 * Solve 함수
 */
const solution = cases => {
  const dp = Array.from({ length: 30 }, () =>
    Array.from({ length: 30 }, () => 0),
  );

  for (let i = 1; i < 30; i++) {
    for (let j = 1; j < 30; j++) {
      if (i === 1) {
        dp[i][j] = j;
      } else if (i === j) {
        dp[i][j] = 1;
      } else if (j > i) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
      }
    }
  }

  for (const [N, M] of cases) {
    console.log(dp[N][M]);
  }
};

// solution(cases);

/**
 * ========================================================
 * @Title       : 1010
 * @Path        : javascript\문제풀이\boj\z.분류없음\1010_다리놓기.spec.js
 * @Link        : https://www.acmicpc.net/problem/1010
 * @Description : 다리 놓기
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              : 파스칼 삼각형
 * @Date        : 2021-08-20 12:45:14
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('1010_다리놓기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [
      [2, 2],
      [1, 5],
      [13, 29],
    ];
    // 함수 실행
    solution(input);
    // 결과
    const result = [1, 5, 67863915];

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
