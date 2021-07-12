/*=======================================================================================
[선택 정렬]
N개이 숫자가 입력되면 오름차순으로 선택정렬하는 프로그램을 작성하라.
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에 자연수 N(1<=N<=100)이 주어진다.
// 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력되며 각 자연수는 정수형 범위 안에 있다.

// ▣ 출력설명
// 오름차순으로 정렬된 수열을 출력한다.

// ▣ 입력예제 1
// 6
// 13 5 11 7 23 15

// ▣ 출력예제 1
// 5 7 11 13 15 23

function solution(arr) {
  let answer = arr;

  return answer;
}

/**
 * ========================================================
 * @Title       : 01_선택정렬
 * @Path        : javascript\02_Solved\inflearn\g.sortingANDgreedANDdecision\01_선택정렬.spec.js
 * @Description :
 * @Date        : 2021-07-12 21:49:59
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_선택정렬', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let arr = [13, 5, 11, 7, 23, 15];
    const result = [5, 7, 11, 13, 15, 23];

    // 테스트 결과 정의
    expect(solution(arr)).toEqual(result);
  });
});
