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
function solution(N, input) {
  let count = 0;
  for (let i = 0; i < N; i++) {
    let str = input[i];
    let record = [];
    for (let j = 0; j < str.length; j++) {
      if (record.indexOf(str[j]) === -1) {
        record.push(str[j]);
      } else {
        if (record[record.length - 1] !== str[j]) {
          count--;
          break;
        }
      }
    }
    count++;
  }
  return count;
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 1316
 * @Path        : javascript\문제풀이\boj\a.문자열\10_1316.spec.js
 * @Link        : https://www.acmicpc.net/problem/1316
 * @Description : 그룹 단어 체커
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:48:11
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('10_1316', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 3;
    const input = ['happy', 'new', 'year'];
    // 함수 실행
    console.log(solution(N, input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 4;
    const input = ['aba', 'abab', 'abcabc', 'a'];
    // 함수 실행
    console.log(solution(N, input));
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 4;
    const input = ['aba', 'abab', 'abcabc', 'acdca'];
    // 함수 실행
    console.log(solution(N, input));
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
