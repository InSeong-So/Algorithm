/**
 * 입력
 */
var input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const N = parseInt(input.shift());
const a = input[0].split(' ').map(item => {
  return parseInt(item);
});
a.unshift(0);
const d1 = [];
const d2 = [];

d1[1] = 1;
d2[N] = 1;

for (let i = 2; i < N + 1; i++) {
  let max = 0;
  for (let j = 1; j < i; j++) {
    if (a[i] > a[j] && max < d1[j]) {
      max = d1[j];
    }
  }
  d1[i] = max + 1;
}

for (let i = N; i > 0; i--) {
  let max = 0;
  for (let j = i; j < N + 1; j++) {
    if (a[i] > a[j] && max < d2[j]) {
      max = d2[j];
    }
  }
  d2[i] = max + 1;
}

let answer = 0;
for (let i = 1; i < N + 1; i++) {
  if (answer < d1[i] + d2[i] - 1) {
    answer = d1[i] + d2[i] - 1;
  }
}
console.log(answer);

/**
 * ========================================================
 * @Title       : 12_11054
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\12_11054.spec.js
 * @Link        : https://www.acmicpc.net/problem/12_11054
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:45:45
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('12_11054', () => {
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
