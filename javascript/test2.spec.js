function solution(money, cost) {
  let answer = Number.MIN_SAFE_INTEGER;

  let left = 0;
  let right = 0;
  let sum = 0;
  let cnt = 0;

  while (left < cost.length) {
    if (right === cost.length) {
      left++;
      right = left;
      sum = 0;
      answer = answer < cnt ? cnt : answer;
      cnt = 0;
      continue;
    }

    sum += cost[right++];

    if (sum <= money) {
      cnt++;
    } else {
      left++;
      right = left;
      sum = 0;
      answer = answer < cnt ? cnt : answer;
      cnt = 0;
    }
  }

  return answer;
}

describe('테스트', () => {
  it('기본 테스트 케이스1', () => {
    let k = 420;
    let rates = [0, 900, 0, 200, 150, 0, 30, 50];
    let result = 5;
    expect(solution(k, rates)).toEqual(result);
  });

  it('기본 테스트 케이스2', () => {
    let k = 100;
    let rates = [245, 317, 151, 192];
    let result = 0;
    expect(solution(k, rates)).toEqual(result);
  });
});
