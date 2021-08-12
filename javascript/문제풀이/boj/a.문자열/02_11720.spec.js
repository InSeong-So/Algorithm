/**
 * 입력
 */
// const fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n'); // 여러줄

/**
 * Solve 함수
 */
function solution(N, M) {
  let sum = 0;
  for (let i = 0; i < Number(N); i++) {
    sum += Number(M[i]);
  }
  console.log(sum);
  // return 1;
}

/**
 * ========================================================
 * @Title       : 11720
 * @Path        : javascript\문제풀이\boj\a.문자열\02_11720.spec.js
 * @Link        : https://www.acmicpc.net/problem/11720
 * @Description : 숫자의 합
 * @Note        : 기본3 테스트케이스는 일반적인 정수 자료형에 담기에 너무 크다.
 * @Date        : 2021-08-12 11:34:57
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('02_11720', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = '1';
    const M = '1';
    // 함수 실행
    solution(N, M);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = '5';
    const M = '54321';
    // 함수 실행
    solution(N, M);
    // 결과
    const result = 15;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = '25';
    const M = '7000000000000000000000000';
    // 함수 실행
    solution(N, M);
    // 결과
    const result = 7;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = '11';
    const M = '10987654321';
    // 함수 실행
    solution(N, M);
    // 결과
    const result = 46;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
