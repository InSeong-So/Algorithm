/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
// const N = Number(input[0]);
// const cards = [0].concat(input[1].split(' ').map(e => Number(e)));

// solution(input);

/**
 * Solve 함수
 */
const solution = (N, cards) => {
  const dp = Array(N + 1).fill(0);

  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= i; j++) {
      dp[i] = Math.max(dp[i - j] + cards[j], dp[i]);
    }
  }

  console.log(dp[N]);
};

/**
 * ========================================================
 * @Title       : 11052
 * @Path        : javascript\문제풀이\boj\z.분류없음\11052_카드구매하기.spec.js
 * @Link        : https://www.acmicpc.net/problem/11052
 * @Description : 카드 구매하기
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-20 13:52:55
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('11052_카드구매하기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [1, 5, 6, 7];
    const cards = [0].concat(input);
    // 함수 실행
    solution(4, cards);
    // 결과
    const result = 10;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [10, 9, 8, 7, 6];
    const cards = [0].concat(input);
    // 함수 실행
    solution(5, cards);
    // 결과
    const result = 50;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55];
    const cards = [0].concat(input);
    // 함수 실행
    solution(10, cards);
    // 결과
    const result = 55;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [5, 10, 11, 12, 13, 30, 35, 40, 45, 47];
    const cards = [0].concat(input);
    // 함수 실행
    solution(10, cards);
    // 결과
    const result = 50;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본5', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [5, 2, 8, 10];
    const cards = [0].concat(input);
    // 함수 실행
    solution(4, cards);
    // 결과
    const result = 20;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본6', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [3, 5, 15, 16];
    const cards = [0].concat(input);
    // 함수 실행
    solution(4, cards);
    // 결과
    const result = 18;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
