/**
 * 입력
 */
const input = require('fs')
  .readFileSync('dev/stdin')
  .toString()
  .trim()
  .split(require('os').EOL);
const N = +input[0];
const nums = input[1]
  .split(' ')
  .map(e => +e)
  .sort((a, b) => a - b);
const X = +input[2];

const solution = (N, nums, X) => {
  let left = 0;
  let right = N - 1;

  let answer = 0;
  let sum = 0;
  while (left < right) {
    sum = nums[left] + nums[right];
    if (sum === X) {
      answer++;
    } else if (sum < X) {
      left++;
      continue;
    }
    right--;
  }

  console.log(answer);
};

solution(N, nums, X);

/**
 * ========================================================
 * @Title       : 두_수의_합
 * @Path        : javascript/problem/boj/two_pointer/두_수의_합(3273).spec.js
 * @Link        : https://www.acmicpc.net/problem/3273
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-04 00:49:33
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('두_수의_합(3273)', () => {
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
