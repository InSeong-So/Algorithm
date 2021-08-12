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
function solution(input) {
  const dp = Array.from({ length: input + 1 }, () => 0);
  dp[1] = 1;
  dp[2] = 2;
  for (let i = 3; i <= input; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
  }
  return dp[input];
}

/**
 * ========================================================
 * @Title       : 1904
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\03_1904.spec.js
 * @Link        : https://www.acmicpc.net/problem/1904
 * @Description : 01타일
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 15:17:41
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('03_1904', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 4;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 5;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('반례1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 10000;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 4537;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('반례2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 46;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 7857;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
