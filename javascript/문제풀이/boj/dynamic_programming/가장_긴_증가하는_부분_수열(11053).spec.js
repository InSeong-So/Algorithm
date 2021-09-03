/**
 * 입력
 */
let line = require('fs').readFileSync('/dev/stdin', 'utf8');
let data = line.trim().split('\n');
let n = parseInt(data[0]);
data = data[1].split(' ').map(function (a) {
  return parseInt(a);
});
data.unshift(0);

let dp = [0];

for (let i = 1; i <= n; i++) {
  dp[i] = 1;
  for (let j = 1; j < i; j++) {
    if (data[j] < data[i] && dp[j] + 1 > dp[i]) {
      dp[i] = dp[j] + 1;
    }
  }
}

let answer = -1001;

for (let k = 0; k < dp.length; k++) {
  answer = Math.max(answer, dp[k]);
}
console.log(answer);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 11_11053
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\11_11053.spec.js
 * @Link        : https://www.acmicpc.net/problem/11053
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:44:09
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('11_11053', () => {
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
