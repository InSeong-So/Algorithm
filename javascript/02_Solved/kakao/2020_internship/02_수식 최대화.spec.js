function solution(expression) {
  let answer = [];

  // 우선순위
  let expr = [
    ['+', '-', '*'],
    // ['+', '*', '-'],
    // ['-', '+', '*'],
    // ['-', '*', '+'],
    // ['*', '+', '-'],
    // ['*', '-', '+'],
  ];

  // let k = '100-200*300-500+20';

  for (let i = 0; i < expr.length; i++) {
    let calcExpr = expression;
    // 우선순위별로 반복
    for (let j = 0; j < 3; j++) {
      let intValue = calcExpr.split(/[^0-9]/gi);
      let exprValue = calcExpr.replace(/[0-9]/gi, '').split('');
      for (let k = 0; k < exprValue.length; k++) {
        if (expr[i][j] === exprValue[k]) {
          console.log(calcExpr, intValue, exprValue);
          console.log(
            exprValue[k],
            parseInt(intValue[k]),
            parseInt(intValue[k + 1]),
          );
          let exec = calc(
            exprValue[k],
            parseInt(intValue[k]),
            parseInt(intValue[k + 1]),
          );
          console.log(exec);
          calcExpr = calcExpr.replace(
            intValue[k].toString() +
              exprValue[k].toString() +
              intValue[k + 1].toString(),
            exec,
          );
          // console.log(calcExpr);
        }
      }
    }
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

  // console.log(answer);
  return answer;
}

let k = '100-200*300-500+20';
// let k = '50*6-3*2';
solution(k);

// /**
//  * ========================================================
//  * @Title       : 02_수식 최대화
//  * @Path        : javascript\02_Solved\kakao\2020_internship\02_수식 최대화.spec.js
//  * @Description :
//  * @Date        : 2021-07-09 21:46:47
//  * --------------------------------------------------------
//  * @Author      : Inseong-so(https://github.com/inseong-so)
//  * ========================================================
//  */
// describe('02_수식 최대화', () => {
//   // 테스트 케이스명
//   it('기본1', () => {
//     // 파라미터 정의
//     let k = '100-200*300-500+20';
//     const result = 60420;

//     // 테스트 결과 정의
//     expect(solution(k)).toEqual(result);
//   });
// });
