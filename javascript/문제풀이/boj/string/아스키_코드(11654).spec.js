/**
 * 입력
 */
// const fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString();

/**
 * Solve 함수
 */
function solution(n) {
  console.log(n.charCodeAt(0));
  // return 1;
}

// solution(input);

/**
 * ========================================================
 * @Title       : 11654
 * @Path        : javascript\문제풀이\boj\a.문자열\01_11654.spec.js
 * @Link        : https://www.acmicpc.net/problem/11654
 * @Description : 아스키 코드
 * @Note        :
 * @Date        : 2021-08-12 11:21:07
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_11654', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    const N = 'A';
    solution(N);
    const result = 65;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  it('기본2', () => {
    console.log = jest.fn();
    const N = 'C';
    solution(N);
    const result = 67;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  it('기본3', () => {
    console.log = jest.fn();
    const N = '0';
    solution(N);
    const result = 48;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  it('기본4', () => {
    console.log = jest.fn();
    const N = '9';
    solution(N);
    const result = 57;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  it('기본5', () => {
    console.log = jest.fn();
    const N = 'a';
    solution(N);
    const result = 97;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  it('기본6', () => {
    console.log = jest.fn();
    const N = 'z';
    solution(N);
    const result = 122;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
