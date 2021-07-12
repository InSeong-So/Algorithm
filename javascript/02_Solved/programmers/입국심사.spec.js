// 문제 : https://programmers.co.kr/learn/courses/30/lessons/43238

function solution(n, times) {
  let min = Math.min(...times) * Math.ceil(n / times.length);
  let max = Math.max(...times) * Math.ceil(n / times.length);
  while (max > min) {
    const mid = Math.floor((min + max) / 2);
    let person = n;
    for (const time of times) {
      person -= Math.floor(mid / time);
      if (person <= 0) break;
    }
    if (person <= 0) {
      max = mid;
    } else {
      min = mid + 1;
    }
  }

  return min;
}

/**
 * ========================================================
 * @Title       : 입국심사
 * @Path        : javascript\02_Solved\programmers\입국심사.spec.js
 * @Description :
 * @Date        : 2021-07-12 00:40:11
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('입국심사', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let n = 6;
    let times = [7, 10];
    const result = 28;

    // 테스트 결과 정의
    expect(solution(n, times)).toEqual(result);
  });
});
