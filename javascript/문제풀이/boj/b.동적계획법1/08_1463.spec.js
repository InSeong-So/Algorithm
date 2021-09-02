/**
 * 입력
 */
const N = Number(require('fs').readFileSync('/dev/stdin').toString().trim());

const count = Array(N + 1).fill(0);
count[1] = 0;

for (let i = 2; i <= N; i++) {
  count[i] = count[i - 1] + 1;
  if (i % 2 === 0) count[i] = Math.min(count[i], count[i / 2] + 1);
  if (i % 3 === 0) count[i] = Math.min(count[i], count[i / 3] + 1);
}

console.log(count[N]);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 08_1463
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\08_1463.spec.js
 * @Link        : https://www.acmicpc.net/problem/08_1463
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:40:14
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('08_1463', () => {
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
