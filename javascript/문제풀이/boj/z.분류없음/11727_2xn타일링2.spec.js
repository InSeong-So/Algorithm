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
  let dp = Array.from({ length: 1001 }, () => 0);
  dp[1] = 1;
  dp[2] = 3;
  for (let i = 3; i <= input; i++) {
    dp[i] = dp[i - 1] + 2 * dp[i - 2];
  }

  console.log(dp[input] % 10007);
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 11727
 * @Path        : javascript\문제풀이\boj\z.분류없음\11727_2xn타일링2.spec.js
 * @Link        : https://www.acmicpc.net/problem/11727
 * @Description : 2xn타일링2
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-19 19:20:45
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('11727_2xn타일링2', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 2;
    // 함수 실행
    solution(input);
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 8;
    // 함수 실행
    solution(input);
    // 결과
    const result = 171;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 12;
    // 함수 실행
    solution(input);
    // 결과
    const result = 2731;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 1;
    // 함수 실행
    solution(input);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
