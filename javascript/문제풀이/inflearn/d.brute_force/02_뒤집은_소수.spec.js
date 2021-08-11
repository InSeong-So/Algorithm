/*=======================================================================================
[ 뒤집은 소수 ]
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하라.
예를 들어 32를 뒤집으면 23이고, 23이 소수라면 23을 출력한다.
단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 N(3<=N<=100)개의 자연수가 주어지며, 각 자연수의 크기는 100,000를 넘지 않는다.

// ▣ 출력설명
// 첫 줄에 뒤집은 소수를 출력한다. 출력순서는 입력된 순서대로 출력한다.

// ▣ 입력예제 1
// 32 55 62 20 250 370 200 30 100

// ▣ 출력예제 1
// 23 2 73 2 3

// 소수 구하기 함수
const isPrime = require('../../../lib/utils/isPrime');

function solution(arr) {
  let answer = [];

  // 배열의 원소를 뒤집기
  arr = arr.map(item => {
    // reduce 사용
    return Number(
      item
        .toString()
        .split('')
        .reduce((reverse, char) => char + reverse, ''),
    );
    // reverse 사용
    // return Number(item.toString().split('').reverse().join(''));
  });

  for (let item of arr) {
    if (isPrime(item)) {
      answer.push(item);
    }
  }

  return answer;
}

describe('뒤집은 소수', () => {
  it('기본 테스트 케이스', () => {
    let arr = [32, 55, 62, 20, 250, 370, 200, 30, 100];
    expect(solution(arr)).toEqual([23, 2, 73, 2, 3]);
  });
});
