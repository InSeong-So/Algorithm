/**
 * 입력
 */
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8').trim().split('\n');

const INVENTORY = input.map(str => str.split(' ').map(c => +c));
const [N, K] = INVENTORY.shift();

function solution() {
  const matrix = Array(K + 1).fill(0);

  INVENTORY.forEach(([w, v]) => {
    for (let i = K; i >= w; i -= 1) {
      matrix[i] = Math.max(matrix[i], matrix[i - w] + v);
    }
  });

  return matrix[K];
}

console.log(solution());

/**
 * ========================================================
 * @Title       : 16_12865
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\16_12865.spec.js
 * @Link        : https://www.acmicpc.net/problem/16_12865
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:48:02
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('16_12865', () => {
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
