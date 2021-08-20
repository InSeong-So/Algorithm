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
  return input;
}

// console.log(solution(input));

/**
 * ========================================================
 * @Title       : 1967
 * @Path        : javascript\문제풀이\boj\z.분류없음\1967_트리의지름.spec.js
 * @Link        : https://www.acmicpc.net/problem/1967
 * @Description : 트리의 지름
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              : https://blog.myungwoo.kr/112
 * @Date        : 2021-08-18 09:46:39
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('1967_트리의지름', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = '';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
