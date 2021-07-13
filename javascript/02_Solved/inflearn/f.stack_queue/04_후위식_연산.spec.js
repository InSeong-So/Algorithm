/*=======================================================================================
[후위식 연산(postfix)]
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하라.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12이다.
=======================================================================================*/

const { default: Stack } = require('@snippet/structure/Stack');

// ▣ 입력설명
// 첫 줄에 후위연산식이 주어진다. 연산식의 길이는 50을 넘지 않는다.
// 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

// ▣ 출력설명
// 연산한 결과를 출력합니다.

// ▣ 입력예제 1
// 352+*9-

// ▣ 출력예제 1
// 12

function solution(s) {
  let stack = [];
  for (let e of s) {
    if (!isNaN(e)) {
      stack.push(Number(e));
    } else {
      let right = stack.pop();
      let left = stack.pop();
      if (e === '+') {
        stack.push(left + right);
      } else if (e === '-') {
        stack.push(left - right);
      } else if (e === '*') {
        stack.push(left * right);
      } else if (e === '/') {
        stack.push(left / right);
      }
    }
  }

  return stack.pop();
}

/**
 * ========================================================
 * @Title       : 04_후위식_연산
 * @Path        : javascript\02_Solved\inflearn\f.stackANDqueue\04_후위식_연산.spec.js
 * @Description :
 * @Date        : 2021-07-12 21:36:35
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('04_후위식_연산', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let str = '352+*9-';
    const result = 12;

    // 테스트 결과 정의
    expect(solution(str)).toEqual(result);
  });
});
