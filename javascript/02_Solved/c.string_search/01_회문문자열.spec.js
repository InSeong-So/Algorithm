/*=======================================================================================
[ 회문 문자열 ]
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 한다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하라.
단, 회문을 검사할 때 대소문자를 구분하지 않는다.
=======================================================================================*/

// ▣ 입력설명
// 첫 줄에 정수 길이 100을 넘지 않는 공백이 없는 문자열이 주어진다.

// ▣ 출력설명
// 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력한다.

// ▣ 입력예제 1
// gooG

// ▣ 출력예제 1
// YES
function solution(s) {
  let answer = 'YES';
  let goal = Math.floor(s.length / 2);
  for (let i = 0; i < goal; i++) {
    let left = s[i].toLowerCase();
    let right = s[s.length - 1 - i].toLowerCase();
    if (left !== right) {
      answer = 'NO';
      break;
    }
  }
  return answer;
}

describe('회문문자열', () => {
  let str = 'gooG';
  let str2 = 'notanswer';

  it('기본 테스트 케이스1', () => {
    expect(solution(str)).toEqual('YES');
  });

  it('기본 테스트 케이스2', () => {
    expect(solution(str2)).toEqual('NO');
  });
});
