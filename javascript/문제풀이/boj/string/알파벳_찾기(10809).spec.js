/**
 * 입력
 */
// const fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄

/**
 * Solve 함수
 */
function solution(str) {
  const compareAlpha = 'abcdefghijklmnopqrstuvwxyz';
  let answer = '';
  for (let cc of compareAlpha) {
    answer += str.indexOf(cc) + ' ';
  }
  console.log(answer.trim());
  // return 1;
}

// solution()

/**
 * ========================================================
 * @Title       : 10809
 * @Path        : javascript\문제풀이\boj\a.문자열\03_10809.spec.js
 * @Link        : https://www.acmicpc.net/problem/10809
 * @Description : 알파벳 찾기
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 12:57:12
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('03_10809', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'baekjoon';
    // 함수 실행
    solution(input);
    // 결과
    const result =
      '1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
