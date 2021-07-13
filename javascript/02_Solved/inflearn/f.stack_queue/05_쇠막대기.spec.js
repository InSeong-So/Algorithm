/*=======================================================================================
[쇠막대기]

https://www.acmicpc.net/problem/10799
=======================================================================================*/

function solution(s) {
  let answer = 0;
  let stack = [];
  for (let i = 0; i < s.length; i++) {
    if (s[i] === '(') {
      stack.push(s[i]);
    } else {
      // 위에서 빼준 다음 확인해야 이상이 없다.
      stack.pop();
      // 닫는 괄호를 만나면 확인한다.
      if (s[i - 1] === '(') {
        // 레이저의 끝
        answer += stack.length;
      } else {
        // 막대기의 끝
        answer += 1;
      }
    }
  }
  return answer;
}

/**
 * ========================================================
 * @Title       : 05_쇠막대기
 * @Path        : javascript\02_Solved\inflearn\f.stackANDqueue\05_쇠막대기.spec.js
 * @Description :
 * @Date        : 2021-07-12 21:37:57
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('05_쇠막대기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let a = '()(((()())(())()))(())';
    const result = 17;

    // 테스트 결과 정의
    expect(solution(a)).toEqual(result);
  });

  it('기본2', () => {
    // 파라미터 정의
    let a = '(((()(()()))(())()))(()())';
    const result = 24;

    // 테스트 결과 정의
    expect(solution(a)).toEqual(result);
  });
});
