/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄
// let input = fs.readFileSync('/dev/stdin').toString().split(os.EOL); // 다른 방식

// solution(input);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

let fs = require('fs');
const input = fs.readFileSync('./dev/stdin').toString().split('\n');

const numbers = input[1].split(' ').map(e => +e);
const operators = input[2].split(' ').map(e => +e);

let max = -Infinity;
let min = Infinity;

function operation(num1, num2, operator) {
  switch (operator) {
    case 0:
      return num1 + num2;
    case 1:
      return num1 - num2;
    case 2:
      return num1 * num2;
    case 3:
      return num1 >= 0 ? Math.floor(num1 / num2) : -Math.floor(-num1 / num2);
  }
}

function dfs(index, result, operators) {
  if (index === numbers.length) {
    max = Math.max(max, result);
    min = Math.min(min, result);
  }

  for (let i = 0; i < 4; i++) {
    if (operators[i] > 0) {
      const newOpers = Array.from(operators);
      newOpers[i] -= 1;
      dfs(index + 1, operation(result, numbers[index], i), newOpers);
    }
  }
}

dfs(1, numbers[0], operators);

console.log(max ? max : 0);
console.log(min ? min : 0);

/**
 * ========================================================
 * @Title       : 14888_연산자끼워넣기
 * @Path        : javascript\문제풀이\boj\z.분류없음\14888_연산자끼워넣기.spec.js
 * @Link        : https://www.acmicpc.net/problem/14888
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              : https://stackoverflow.com/questions/4215737/convert-array-to-object
 * @Date        : 2021-08-25 09:19:42
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('14888_연산자끼워넣기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = '';
    // 함수 실행
    solution(input);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
