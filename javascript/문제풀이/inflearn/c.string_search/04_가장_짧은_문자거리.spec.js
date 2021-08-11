/*=======================================================================================
[ 가장 짧은 문자거리 ]
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하라.
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어진다.
// 문자열의 길이는 100을 넘지 않는다.

// ▣ 출력설명
// 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

// ▣ 입력예제 1
// teachermode e

// ▣ 출력예제 1
// 1 0 1 2 1 0 1 2 2 1 0

function solution(s, t) {
  let left = [];
  let right = [];
  let answer = [];

  let count = 0;
  for (let char of s) {
    if (char === t) {
      left.push(0);
      count = 0;
      continue;
    }
    count++;
    left.push(count);
  }
  count = 0;
  for (let char of s.split('').reverse().join('')) {
    if (char === t) {
      right.push(0);
      count = 0;
      continue;
    }
    count++;
    right.push(count);
  }
  right.reverse();

  for (let i = 0; i < left.length; i++) {
    if (left[i] >= right[i]) {
      answer.push(right[i]);
    } else {
      answer.push(left[i]);
    }
  }
  return answer;
}

describe('가장 짧은 문자거리', () => {
  let str = 'teachermode';

  it('기본 테스트 케이스1', () => {
    expect(solution(str, 'e')).toEqual([1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0]);
  });
});
