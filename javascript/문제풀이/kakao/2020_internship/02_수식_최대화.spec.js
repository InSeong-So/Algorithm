function solution(expression) {
  // 우선순위
  let operators = [
    ['*', '+', '-'],
    ['*', '-', '+'],
    ['+', '*', '-'],
    ['+', '-', '*'],
    ['-', '*', '+'],
    ['-', '+', '*'],
  ];

  let mem = []; // type = operators idx

  for (let i = 0; i < operators.length; i++) {
    let tempExpression = JSON.parse(
      '[' +
        expression
          .replace(/[+]/gi, ',"+",')
          .replace(/[-]/gi, ',"-",')
          .replace(/[*]/gi, ',"*",') +
        ']',
    );
    for (let j = 0; j < 3; j++) {
      while (true) {
        let operatorIdx = tempExpression.findIndex(e => {
          return e == operators[i][j];
        });
        if (operatorIdx != -1) {
          let left = tempExpression[operatorIdx - 1];
          let right = tempExpression[operatorIdx + 1];
          let operator = tempExpression[operatorIdx];
          let result = calc(left, operator, right);
          tempExpression.splice(operatorIdx - 1, 3, result);
        } else {
          break;
        }
      }
    }
    mem[i] = Math.abs(tempExpression[0]);
  }

  function calc(a, expr, b) {
    switch (expr) {
      case '+': {
        return a + b;
      }
      case '-': {
        return a - b;
      }
      case '*': {
        return a * b;
      }
    }
  }

  console.log(mem);

  return Math.max(...mem);
}

/**
 * ========================================================
 * @Title       : 02_수식 최대화
 * @Path        : javascript\02_Solved\kakao\2020_internship\02_수식 최대화.spec.js
 * @Description :
 * @Date        : 2021-07-09 21:46:47
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('02_수식 최대화', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let k = '100-200*300-500+20';
    const result = 60420;

    // 테스트 결과 정의
    expect(solution(k)).toEqual(result);
  });
  it('기본1', () => {
    // 파라미터 정의
    let k = '50*6-3*2';
    const result = 300;

    // 테스트 결과 정의
    expect(solution(k)).toEqual(result);
  });
});
