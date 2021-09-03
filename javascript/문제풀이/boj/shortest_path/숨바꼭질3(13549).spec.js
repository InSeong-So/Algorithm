/**
 * 입력
 */
// const input = require('fs').readFileSync('dev/stdin').toString().split('\n');
// const [start, end] = input[0].split(' ').map(el => Number(el));

/**
 * Solve 함수
 */
function solution(start, end) {
  const BFS = v => {
    const times = Array.from({ length: 100001 }, () => -1);
    let queue = [v];
    times[v] = 0;
    while (queue.length > 0) {
      const lv = queue.shift();
      if (lv == end) {
        break;
      }
      const plus = lv + 1;
      const subtract = lv - 1;
      const multiple = lv * 2;
      if (multiple <= 100000 && times[multiple] === -1) {
        times[multiple] = times[lv];
        queue.push(multiple);
      }
      if (subtract >= 0 && times[subtract] === -1) {
        times[subtract] = times[lv] + 1;
        queue.push(subtract);
      }
      if (plus <= 100000 && times[plus] === -1) {
        times[plus] = times[lv] + 1;
        queue.push(plus);
      }
    }

    return times[end];
  };

  console.log(BFS(start));
}

// solution(5, 17);

/**
 * ========================================================
 * @Title       : 13549
 * @Path        : javascript\문제풀이\boj\z.분류없음\13549_숨바꼭질3.spec.js
 * @Link        : https://www.acmicpc.net/problem/13549
 * @Description : 숨바꼭질3
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-16 10:14:37
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('13549_숨바꼭질3', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const start = 5;
    const end = 17;
    // 함수 실행
    console.log(solution(start, end));
    // 결과
    const result = 2;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('최악1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const start = 7;
    const end = 100000;
    // 함수 실행
    console.log(solution(start, end));
    // 결과
    const result = 5;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('최악2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const start = 8;
    const end = 100000;
    // 함수 실행
    console.log(solution(start, end));
    // 결과
    const result = 6;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
