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
  if (input < 3) {
    console.log(1);
  } else {
    const dp = Array.from({ length: 91 }, () => 0);
    dp[1] = 1;
    dp[2] = 1;
    for (let i = 3; i <= input; i++) {
      dp[i] = BigInt(dp[i - 1]) + BigInt(dp[i - 2]);
    }
    console.log(BigInt(dp[input]).toString());
  }
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 2193
 * @Path        : javascript\문제풀이\boj\z.분류없음\2193_이친수.spec.js
 * @Link        : https://www.acmicpc.net/problem/2193
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-17 21:46:52
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('2193_이친수', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 3;
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 2;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
