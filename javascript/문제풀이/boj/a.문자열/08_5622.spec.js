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
  return input
    .trim('')
    .split('')
    .map(function (e) {
      let x = Math.floor((e.charCodeAt() - 'A'.charCodeAt()) / 3) + 1 + 2;
      switch (e) {
        case 'S':
        case 'V':
        case 'Y':
        case 'Z':
          x -= 1;
          break;
      }
      return x;
    })
    .reduce(function (prev, curr) {
      return prev + curr;
    });
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 5622
 * @Path        : javascript\문제풀이\boj\a.문자열\08_5622.spec.js
 * @Link        : https://www.acmicpc.net/problem/5622
 * @Description : 다이얼
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:38:51
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('08_5622', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'WA';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 13;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'UNUCIC';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 36;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
