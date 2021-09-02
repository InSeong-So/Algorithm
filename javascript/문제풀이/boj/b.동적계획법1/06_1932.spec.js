/**
 * 입력
 */
const data = require('fs')
  .readFileSync('dev/stdin', 'utf8')
  .toString()
  .trim()
  .split('\n');

const cache = [new Array(501).fill(0), new Array(501).fill(0)];

const cal = (arr, next) => {
  let pre = (next + 1) % 2;
  arr.forEach((item, idx) => {
    if (idx === 0) {
      cache[next][idx] = cache[pre][idx] + item;
    } else if (idx === arr.length - 1) {
      cache[next][idx] = cache[pre][idx - 1] + item;
    } else {
      cache[next][idx] = Math.max(cache[pre][idx - 1], cache[pre][idx]) + item;
    }
  });
};

const n = Number(data[0]);
data.shift();

data.forEach((item, idx) => cal(item.split(' ').map(Number), idx % 2));

console.log(Math.max(...cache[(n + 1) % 2]));

// solution(input);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 06_1932
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\06_1932.spec.js
 * @Link        : https://www.acmicpc.net/problem/06_1932
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:38:54
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('06_1932', () => {
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
