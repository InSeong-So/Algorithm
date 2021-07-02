/*=======================================================================================
[ 숫자만 추출 ]
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만든다.
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 된다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않는다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 숫자가 섞인 문자열이 주어진다. 문자열의 길이는 50을 넘지 않는다.

// ▣ 출력설명
// 첫 줄에 자연수를 출력한다.

// ▣ 입력예제 1
// g0en2T0s8eSoft

// ▣ 출력예제 1
// 208

// 정규식으로 풀었는데... search이므로 loop 도는게 맞는 것 같음
function solution(str) {
  let answer = '';
  const regExp = /[^0-9]/g;
  answer = str.replace(regExp, '');

  return parseInt(answer);
}

// loop 돌아서 문자를 하나하나 비교하고, isNaN 함수를 사용하여 체크함
function solution2(str) {
  let answer = 0;

  for (let x of str) {
    if (!isNaN(x)) {
      answer = answer * 10 + Number(x);
    }
  }

  return answer;
}

describe('숫자만 추출', () => {
  let str = 'g0en2T0s8eSoft';
  let str2 = 'g0en42T0s18eSoft';

  it('기본 테스트 케이스1', () => {
    expect(solution(str)).toEqual(208);
  });

  it('기본 테스트 케이스2', () => {
    expect(solution(str2)).toEqual(42018);
  });

  it('기본 테스트 케이스1-2', () => {
    expect(solution2(str)).toEqual(208);
  });

  it('기본 테스트 케이스2-2', () => {
    expect(solution2(str2)).toEqual(42018);
  });
});
