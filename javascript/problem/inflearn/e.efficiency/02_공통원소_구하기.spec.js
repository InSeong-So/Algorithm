/*=======================================================================================
[ 공통원소 구하기 ]
A, B 두 개의 배열이 주어지면 두 배열의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하라.
=======================================================================================*/

// 크기가 N(1<=N<=30,000)인 배열과 M(1<=M<=30,000)인 배열이 주어진다.
// 각 배열의 원소는 중복되지 않으며 1,000,000,000이하의 자연수이다.

// ▣ 출력설명
// 두 집합의 공통원소를 오름차순 정렬하여 출력한다.

// ▣ 입력예제 1
// 1 3 9 5 2
// 3 2 5 7 8

// ▣ 출력예제 1
// 2 3 5

function solution(arr1, arr2) {
  let answer = [];

  arr1.sort((a, b) => {
    return a - b;
  });

  arr2.sort((a, b) => {
    return a - b;
  });

  let p1 = 0;
  let p2 = 0;

  while (p1 < arr1.length && p2 < arr2.length) {
    if (arr1[p1] === arr2[p2]) {
      answer.push(arr1[p1++]);
      p2++;
    } else if (arr1[p1] < arr2[p2]) {
      p1++;
    } else {
      p2++;
    }
  }

  return answer;
}

function solution2(arr1, arr2) {
  let set1 = new Set(arr1);
  let answer = arr2
    .filter(item => set1.has(item))
    .sort((a, b) => {
      return a - b;
    });
  return answer;
}

describe('공통원소 구하기', () => {
  it('기본 테스트 케이스', () => {
    let a = [1, 3, 9, 5, 2];
    let b = [3, 2, 5, 7, 8];
    expect(solution(a, b)).toEqual([2, 3, 5]);
  });
});
