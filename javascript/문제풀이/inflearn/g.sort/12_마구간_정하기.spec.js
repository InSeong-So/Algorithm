/*=======================================================================================
[마구간 정하기] : 결정 알고리즘
N개의 마구간이 수직선상에 있다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간 간에 좌표가 중복되는 일은 없다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않는다.
각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하라.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 테스트 케이스인 자연수 N(3<=N<=200,000)과 말의 수 C(2<=C<=N)이 공백을 사이에 두고 주어진다.
// 둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어진다.

// ▣ 출력설명
// 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하라.

// ▣ 입력예제 1
// 5 3
// 1 2 8 4 9

// ▣ 출력예제 1
// 3

function solution(c, stable) {
  // left는 첫번째 원소가 되면 안된다.
  let answer;
  stable.sort((a, b) => a - b);
  let left = 1;
  let right = stable[stable.length - 1];

  while (left <= right) {
    let mid = parseInt((left + right) / 2);
    if (count(stable, mid) >= c) {
      answer = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  function count(stable, dist) {
    let cnt = 1;
    let endpoint = stable[0];
    for (let i = 1; i < stable.length; i++) {
      if (stable[i] - endpoint >= dist) {
        cnt++;
        endpoint = stable[i];
      }
    }
    return cnt;
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 12_마구간_정하기
 * @Path        : javascript\02_Solved\inflearn\g.sortingANDgreedANDdecision\12_마구간_정하기.spec.js
 * @Description :
 * @Date        : 2021-07-12 22:05:43
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('12_마구간_정하기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let k = 3;
    let arr = [1, 2, 8, 4, 9];
    const result = 3;

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });
});
