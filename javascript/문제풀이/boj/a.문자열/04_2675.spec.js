/**
 * 입력
 */
// const fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄

/**
 * Solve 함수
 */
function solution(N, str) {
  let answer = '';
  for (let s of str) {
    for (let i = 0; i < N; i++) {
      answer += s;
    }
  }
  console.log(answer.trim());
  // return 1;
}

// 이게 더 빠름
function solution2(N, str) {
  console.log(
    str
      .split('')
      .map(function (c) {
        return Array(N + 1).join(c);
      })
      .join(''),
  );
}

// solution()

/**
 * ========================================================
 * @Title       : 2675
 * @Path        : javascript\문제풀이\boj\a.문자열\04_2675.spec.js
 * @Link        : https://www.acmicpc.net/problem/2675
 * @Description : 문자열 반복
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:01:59
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('04_2675', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 3;
    const input = 'ABC';
    // 함수 실행
    solution(N, input);
    // 결과
    const result = 'AAABBBCCC';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 5;
    const input = '/HTP';
    // 함수 실행
    solution2(N, input);
    // 결과
    const result = '/////HHHHHTTTTTPPPPP';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
