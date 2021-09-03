/**
 * 입력
 */
function lowerBound(array, value) {
  var s = 0;
  var e = array.length;
  var m;
  while (s < e) {
    m = (s + e) >> 1;
    if (array[m] < value) s = m + 1;
    else e = m;
  }
  return e;
}
var fs = require('fs');
var input = fs.readFileSync('/dev/stdin', 'utf8').split('\n');
var idx = 0;
var N = parseInt(input[idx++]);
var A = [];
for (var i = 0; i < N; i++) {
  var tmp = input[idx++].split(' ').map(function (a) {
    return parseInt(a);
  });
  A.push({ a: tmp[0], b: tmp[1] });
}
A.sort(function (a, b) {
  return a.a - b.a;
});
var sequence = [];
for (var i = 0; i < N; i++) {
  sequence.push(A[i].b);
}
var cnt = 0;
var B = [Infinity];
for (var i = 0; i < N; i++) {
  if (B[B.length - 1] < sequence[i]) B.push(sequence[i]);
  else B[lowerBound(B, sequence[i])] = sequence[i];
}
console.log(A.length - B.length);

/**
 * ========================================================
 * @Title       : 13_2565
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\13_2565.spec.js
 * @Link        : https://www.acmicpc.net/problem/13_2565
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:46:32
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('13_2565', () => {
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
