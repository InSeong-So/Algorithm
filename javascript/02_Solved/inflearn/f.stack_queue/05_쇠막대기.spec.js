/*=======================================================================================
[쇠막대기]

https://www.acmicpc.net/problem/10799
=======================================================================================*/

function solution(s) {
  let answer = 0;

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
