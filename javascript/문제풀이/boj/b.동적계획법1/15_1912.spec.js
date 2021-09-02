/**
 * 입력
 */
var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

var len = +input[0];
input = input[1].split(' ').map(Number);

var sum = 0;
var max = 0;

sum = input[0];
max = sum;

for (var i = 1; i < len; i++) {
  if (sum + input[i] > input[i]) {
    sum = sum + input[i];
  } else {
    sum = input[i];
  }
  max = Math.max(max, sum);
}

console.log(Math.max(sum, max));
/**
 * ========================================================
 * @Title       : 15_1912
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\15_1912.spec.js
 * @Link        : https://www.acmicpc.net/problem/15_1912
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:47:38
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('15_1912', () => {
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
