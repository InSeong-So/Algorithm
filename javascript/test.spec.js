function solution(k, rates) {
  let dollor = 0;

  for (let i = 0; i < rates.length; i++) {
    if (i + 1 > rates.length) break;
    // 판다.
    if (
      dollor === 1 &&
      rates[i] > k &&
      (rates[i + 1] <= rates[i] || i === rates.length - 1)
    ) {
      dollor = 0;
      k += rates[i];
      // 산다.
    } else if (dollor === 0 && rates[i] <= k && rates[i + 1] >= rates[i]) {
      dollor = 1;
      k -= rates[i];
    }
  }

  return k;
}

describe('테스트', () => {
  it('기본 테스트 케이스1', () => {
    let k = 1000;
    let rates = [1200, 1000, 1100, 1200, 900, 1000, 1500, 900, 750, 1100];
    let result = 2150;
    expect(solution(k, rates)).toEqual(result);
  });

  it('기본 테스트 케이스2', () => {
    let k = 1500;
    let rates = [1500, 1400, 1300, 1200];
    let result = 1500;
    expect(solution(k, rates)).toEqual(result);
  });
});
