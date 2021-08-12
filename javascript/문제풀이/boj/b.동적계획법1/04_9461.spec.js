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
  const dp = Array.from({ length: 101 }, () => 0);
  dp[0] = 0;
  dp[1] = 1;
  dp[2] = 1;
  dp[3] = 1;

  if (input < 4) {
    return dp[input];
  }
  for (let i = 4; i <= input; i++) {
    dp[i] = dp[i - 2] + dp[i - 3];
  }

  return dp[input];
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 9461
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\04_9461.spec.js
 * @Link        : https://www.acmicpc.net/problem/9461
 * @Description : 파도반 수열
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 15:38:16
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('04_9461', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 6;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 12;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 16;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
