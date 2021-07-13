/*=======================================================================================
[동전교환]
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다.
// 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
// 각 동전의 종류는 100원을 넘지 않는다.

// ▣ 출력설명
// 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

// ▣ 입력예제 1
// 3
// 1 2 5
// 15

// ▣ 출력예제 1
// 3
// 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.

function solution(m, arr) {
  let answer = Number.MAX_SAFE_INTEGER;
  let n = arr.length;

  function DFS(v, sum) {
    if (sum > m) return;
    if (sum === m) {
      answer = Math.min(answer, v);
    } else {
      for (let i = 0; i < n; i++) {
        DFS(v + 1, sum + arr[i]);
      }
    }
  }

  DFS(0, 0);

  return answer;
}

// 답보다 큰 경우의 수는 가지치기로 쳐낸다.
function solution2(m, arr) {
  let answer = Number.MAX_SAFE_INTEGER;
  let n = arr.length;

  function DFS(v, sum) {
    if (sum > m) return;

    // 이부분 추가
    if (v > answer) return;

    if (sum === m) {
      answer = Math.min(answer, v);
    } else {
      for (let i = 0; i < n; i++) {
        DFS(v + 1, sum + arr[i]);
      }
    }
  }

  DFS(0, 0);

  return answer;
}

/**
 * ========================================================
 * @Title       : 09_동전교환
 * @Path        : javascript\02_Solved\inflearn\h.recursion\09_동전교환.spec.js
 * @Description :
 * @Date        : 2021-07-13 12:05:38
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('09_동전교환', () => {
  // 테스트 케이스명
  it('기본1:완전탐색', () => {
    // 파라미터 정의
    let k = 15;
    let arr = [1, 2, 5];
    const result = 3;

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본1:가지치기', () => {
    // 파라미터 정의
    let k = 15;
    let arr = [1, 2, 5];
    const result = 3;

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });
});
