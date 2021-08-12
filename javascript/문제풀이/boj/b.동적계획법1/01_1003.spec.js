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
function solution(nums) {
  let dp_0 = Array.from({ length: 41 }, () => 0);
  let dp_1 = Array.from({ length: 41 }, () => 0);

  dp_0[0] = 1;
  dp_0[1] = 0;
  dp_1[1] = 1;

  for (let i = 2; i < 41; i++) {
    dp_0[i] = dp_0[i - 1] + dp_0[i - 2];
    dp_1[i] = dp_1[i - 1] + dp_1[i - 2];
  }

  let answer = [];
  for (let n of nums) {
    answer.push(dp_0[n] + ' ' + dp_1[n]);
  }
  return answer;
}

/**
 * ========================================================
 * @Title       : 1003
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\01_1003.spec.js
 * @Link        : https://www.acmicpc.net/problem/1003
 * @Description : 피보나치 함수
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 14:04:59
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_1003', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [0, 1, 3];
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = ['1 0', '0 1', '1 2'];

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = [40, 39, 24, 39, 7];
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = [
      '63245986 102334155',
      '39088169 63245986',
      '28657 46368',
      '39088169 63245986',
      '8 13',
    ];

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
