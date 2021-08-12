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
  input = input.trim();
  const regex = new RegExp(/c-|d-|lj|nj|(c|dz|s|z)=|./g);
  return input.replace(regex, ' ').length;
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 2941
 * @Path        : javascript\문제풀이\boj\a.문자열\09_2941.spec.js
 * @Link        : https://www.acmicpc.net/problem/2941
 * @Description : 크로아티아 알파벳
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:41:57
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('09_2941', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'ljes=njak';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 6;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'ddz=z=';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'nljj';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'c=c=';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 2;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본5', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'dz=ak';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
