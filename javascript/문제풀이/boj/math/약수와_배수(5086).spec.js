/**
 * 입력
 */
var n = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(function (e) {
    return e.split(' ').map(function (e) {
      return parseInt(e);
    });
  });
n.pop();
console.log(
  n
    .map(function (e) {
      if (e[0] % e[1] === 0) {
        return 'multiple';
      } else if (e[1] % e[0] === 0) {
        return 'factor';
      } else {
        return 'neither';
      }
    })
    .join('\n'),
);

/**
 * ========================================================
 * @Title       : 약수와_배수(5086)
 * @Path        : javascript\문제풀이\boj\math\약수와_배수(5086).spec.js
 * @Link        : https://www.acmicpc.net/problem/5086
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-03 18:27:15
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('약수와_배수(5086)', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = '';
    // 함수 실행
    solution(input);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
