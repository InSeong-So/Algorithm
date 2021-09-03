/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
// let target = 1;

/**
 * Solve 함수
 */
const solution = (N, stickers) => {
  let dp = Array.from({ length: 3 }, () => Array(N + 1).fill(0));

  dp[1][1] = stickers[0][0];
  dp[2][1] = stickers[1][0];

  for (let i = 2; i <= N; i++) {
    // temp 값
    dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
    // 1라인을 선택했을 때
    dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + stickers[0][i - 1];
    // 2라인을 선택했을 떄
    dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + stickers[1][i - 1];
  }
  console.log(Math.max(dp[1][N], dp[2][N]));
};

// for (let i = 1; i <= Number(input[0]); i++) {
//   const N = Number(input[target]);
//   const stickers = [
//     input[target + 1].split(' ').map(e => Number(e)),
//     input[target + 2].split(' ').map(e => Number(e)),
//   ];
//   solution(N, stickers);
//   target += 3;
// }

/**
 * ========================================================
 * @Title       : 9465
 * @Path        : javascript\문제풀이\boj\z.분류없음\9465_스티커.spec.js
 * @Link        : https://www.acmicpc.net/problem/9465
 * @Description : 스티커
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-20 16:16:34
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('9465_스티커', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 5;
    const stickers = [
      [50, 10, 100, 20, 40],
      [30, 50, 70, 10, 60],
    ];
    // 함수 실행
    solution(N, stickers);
    // 결과
    const result = 260;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 7;
    const stickers = [
      [10, 30, 10, 50, 100, 20, 40],
      [20, 40, 30, 50, 60, 20, 80],
    ];
    // 함수 실행
    solution(N, stickers);
    // 결과
    const result = 290;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
