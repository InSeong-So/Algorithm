/*=======================================================================================
[ 유효한 팰린드롬 ]
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 한다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하라.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않는다.
알파벳 이외의 문자들의 무시한다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어진다.

// ▣ 출력설명
// 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력한다.

// ▣ 입력예제 1
// found7, time: study; Yduts; emit, 7Dnuof

// ▣ 출력예제 1
// YES

function solution(s) {
  let answer = 'YES';
  let goal = Math.floor(s.length / 2);

  let target = s.toLowerCase().replace(/[^A-Za-z]/g, '');

  for (let i = 0; i < goal; i++) {
    let left = target[i];
    let right = target[target.length - 1 - i];

    if (left !== right) {
      answer = 'NO';
    }
  }

  return answer;
}

describe('유효한 팰린드롬', () => {
  let str = 'found7, time: study; Yduts; emit, 7Dnuof';
  let str2 = 'gmddlek';

  it('기본 테스트 케이스1', () => {
    expect(solution(str)).toEqual('YES');
  });

  it('기본 테스트 케이스2', () => {
    expect(solution(str2)).toEqual('NO');
  });
});
