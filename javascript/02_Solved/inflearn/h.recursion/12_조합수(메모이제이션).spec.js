/*=======================================================================================
[조합수] : 메모이제이션
=======================================================================================*/

// ▣ 입력설명
// 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력된다.

// ▣ 출력설명
// 첫째 줄에 조합수를 출력한다.

// ▣ 입력예제 1
// 5 3

// ▣ 출력예제 1
// 10

// ▣ 입력예제 2
// 33 19

// ▣ 출력예제 2
// 818809200

function solution(n, r) {
  function DFS(v, r) {
    if (v === r || r === 0) return 1;

    return DFS(v - 1, r - 1) + DFS(v - 1, r);
  }

  return DFS(n, r);
}

// 2차원 배열을 이용한 메모이제이션
function solution2(n, r) {
  // n행 r열
  let dy = Array.from(Array(n + 1), () => Array(r + 1).fill(0));

  function DFS(v, r) {
    if (dy[v][r] > 0) return dy[v][r];
    if (v === r || r === 0) return 1;

    return (dy[v][r] = DFS(v - 1, r - 1) + DFS(v - 1, r));
  }

  return DFS(n, r);
}

/**
 * ========================================================
 * @Title       : 12_조합수(메모이제이션)
 * @Path        : javascript\02_Solved\inflearn\h.recursion\12_조합수(메모이제이션).spec.js
 * @Description :
 * @Date        : 2021-07-13 12:21:30
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('12_조합수(메모이제이션)', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let k = 5;
    let n = 3;
    const result = 10;

    // 테스트 결과 정의
    expect(solution(k, n)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본2', () => {
    // 파라미터 정의
    let k = 33;
    let n = 19;
    const result = 818809200;

    // 테스트 결과 정의
    expect(solution(k, n)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본1:메모이제이션', () => {
    // 파라미터 정의
    let k = 5;
    let n = 3;
    const result = 10;

    // 테스트 결과 정의
    expect(solution2(k, n)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본2:메모이제이션', () => {
    // 파라미터 정의
    let k = 33;
    let n = 19;
    const result = 818809200;

    // 테스트 결과 정의
    expect(solution2(k, n)).toEqual(result);
  });
});
