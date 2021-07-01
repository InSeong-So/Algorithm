/*=======================================================================================
[ 문자열 압축 ]
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하라.
단 반복횟수가 1인 경우 생략한다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

// ▣ 출력설명
// 첫 줄에 압축된 문자열을 출력한다.

// ▣ 입력예제 1
// KKHSSSSSSSE

// ▣ 출력예제 1
// K2HS7E

function solution(s) {
  let answer = '';

  let count = 0;
  let compare = s.substring(0, 1);
  for (let i = 0; i < s.length; i++) {
    if (s[i] === compare) {
      count++;
    } else {
      answer += compare + (count === 1 ? '' : count);
      compare = s[i];
      count = 1;
    }

    if (i === s.length - 1) {
      answer += compare + (count === 1 ? '' : count);
    }
  }

  return answer;
}

describe('문자열 압축', () => {
  it('기본 테스트 케이스1', () => {
    let str = 'KKHSSSSSSSE';
    expect(solution(str)).toEqual('K2HS7E');
  });
  it('기본 테스트 케이스2', () => {
    let str = 'KKHSSSSSSSEE';
    expect(solution(str)).toEqual('K2HS7E2');
  });
});
