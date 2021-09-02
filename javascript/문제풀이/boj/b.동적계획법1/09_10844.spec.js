/**
 * 입력
 */
var fs = require('fs');
var input = fs.readFileSync('/dev/stdin', 'utf8').split('\n');
var idx = 0;
var n = parseInt(input[idx++]);
var mod = 1e9;
var DT = [];
DT[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1];
for (var i = 2; i <= n; i++) {
  if (!DT[i]) DT[i] = [];
  for (var j = 0; j < 10; j++) {
    DT[i][j] = 0;
    if (j + 1 <= 9) DT[i][j] += DT[i - 1][j + 1];
    if (j - 1 >= 0) DT[i][j] += DT[i - 1][j - 1];
    DT[i][j] %= mod;
  }
}

var ans = DT[n].reduce(function (a, b) {
  return a + b;
});
console.log(ans % mod);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 09_10844
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\09_10844.spec.js
 * @Link        : https://www.acmicpc.net/problem/09_10844
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:42:33
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('09_10844', () => {
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
