/*=======================================================================================
[ 자릿수의 합 ]
N개의 자연수가 입력되면 각 자연수의 자릿수의 합을 구하고, 그 합이 최대인 자연수를 출력하는 프로그램을 작성하라.
자릿수의 합이 같은 경우 원래 숫자가 큰 숫자를 답으로 한다.
만약 235와 1234가 동시에 답이 될 수 있다면 1234를 답으로 출력한다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
// 각 자연수의 크기는 10,000,000를 넘지 않는다.

// ▣ 출력설명
// 자릿수의 합이 최대인 자연수를 출력한다.

// ▣ 입력예제 1
// 7
// 128 460 603 40 521 137 123

// ▣ 출력예제 1
// 137

function solution(n, arr) {
  let answer = Number.MIN_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let item of arr) {
    let sum = 0;
    let temp = item;
    /**
     * temp   temp % 10
     * 128    8
     * 12     2
     * 1      1
     * 0      break
     */
    while (temp) {
      sum += temp % 10;
      temp = Math.floor(temp / 10);
    }

    if (sum > max) {
      max = sum;
      answer = item;
    } else if (sum === max && item > answer) {
      answer = item;
    }
  }

  return answer;
}

function solution2(n, arr) {
  let answer = Number.MIN_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let item of arr) {
    // while문을 변형
    let sum = item
      .toString()
      .split('')
      .reduce((a, b) => a + Number(b), 0);
    if (sum > max) {
      max = sum;
      answer = item;
    } else if (sum === max && item > answer) {
      answer = item;
    }
  }

  return answer;
}

describe('자리수의 합', () => {
  it('기본 테스트 케이스1', () => {
    let arr = [128, 460, 603, 40, 521, 137, 123];
    expect(solution(7, arr)).toEqual(137);
  });

  it('기본 테스트 케이스2', () => {
    let arr = [460, 603, 40, 521, 127, 123, 235, 1234];
    expect(solution(7, arr)).toEqual(1234);
  });
});
