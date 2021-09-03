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
  input = input.toLowerCase();
  let arr = new Array(26).fill(0);
  for (let i = 0; i < input.length; i++) {
    arr[input[i].charCodeAt() - 97] += 1;
  }
  let maxNum = Math.max(...arr);
  let count = [];
  for (let i = 0; i < arr.length; i++) {
    if (maxNum === arr[i]) {
      count.push(i);
    }
  }
  return count.length > 1 ? '?' : String.fromCharCode(count[0] + 65);
}

// console.log(%s, solution(input));

/**
 * ========================================================
 * @Title       : 1157
 * @Path        : javascript\문제풀이\boj\a.문자열\05_1157.spec.js
 * @Link        : https://www.acmicpc.net/problem/1157
 * @Description : 단어 공부
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:16:09
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('05_1157', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'Mississipi';
    // 함수 실행
    solution(input);
    // 결과
    const result = '?';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'zZa';
    // 함수 실행
    solution(input);
    // 결과
    const result = 'Z';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'z';
    // 함수 실행
    solution(input);
    // 결과
    const result = 'Z';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'baaa';
    // 함수 실행
    solution(input);
    // 결과
    const result = 'A';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
