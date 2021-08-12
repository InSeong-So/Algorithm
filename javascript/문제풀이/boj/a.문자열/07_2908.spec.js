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
  return Math.max.apply(
    Math,
    input.map(function (e) {
      return parseInt(e.split('').reverse().join(''));
    }),
  );
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 2908
 * @Path        : javascript\문제풀이\boj\a.문자열\07_2908.spec.js
 * @Link        : https://www.acmicpc.net/problem/2908
 * @Description : 상수
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:31:12
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('07_2908', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = ['734', '893'];
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 437;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = ['221', '231'];
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 132;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = ['839', '237'];
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 938;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
