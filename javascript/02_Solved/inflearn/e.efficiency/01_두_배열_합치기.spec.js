/*=======================================================================================
[ 두 배열 합치기 ]
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하라.
=======================================================================================*/

// ▣ 입력설명
// 크기가 N(1<=N<=100)인 오름차순으로 정렬된 배열과 M(1<=M<=100)인 오름차순으로 정렬된 배열이 주어진다.
// 각 배열의 원소는 int형 변수의 크기를 넘지 않는다.

// ▣ 출력설명
// 오름차순으로 정렬된 배열을 출력한다.

// ▣ 입력예제 1
// 3
// 1 3 5
// 5
// 2 3 6 7 9

// ▣ 출력예제 1
// 1 2 3 3 5 6 7 9

function solution2(arr1, arr2) {
  return [...arr1, ...arr2].sort((a, b) => {
    return a - b;
  });
}

function solution(arr1, arr2) {
  let answer = [];
  let n = arr1.length;
  let m = arr2.length;
  let pointer1 = 0;
  let pointer2 = 0;
  // 두 배열의 동일한 length 만큼 비교
  while (pointer1 < n && pointer2 < m) {
    if (arr1[pointer1] <= arr2[pointer2]) {
      answer.push(arr1[pointer1++]);
    } else {
      answer.push(arr2[pointer2++]);
    }
  }
  // 나머지 연산
  while (pointer1 < n) {
    answer.push(arr1[pointer1++]);
  }

  while (pointer2 < m) {
    answer.push(arr2[pointer2++]);
  }
  return answer;
}

describe('두 배열 합치기', () => {
  it('기본 테스트 케이스', () => {
    let a = [1, 3, 5];
    let b = [2, 3, 6, 7, 9];
    expect(solution(a, b)).toEqual([1, 2, 3, 3, 5, 6, 7, 9]);
  });
});
