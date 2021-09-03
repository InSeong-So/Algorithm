/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// let input = fs.readFileSync('/dev/stdin').toString().split(' '); // 한줄
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');  // 여러줄
// let input = fs.readFileSync('/dev/stdin').toString().split(os.EOL); // 다른 방식

/**
 * Solve 함수
 */
function solution(a, b, c) {
  const dp = Array.from({ length: 51 }, () =>
    Array.from({ length: 21 }, () => Array.from({ length: 21 }, () => 0)),
  );

  function funfun(a, b, c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }
    if (a > 20 || b > 20 || c > 20) {
      return funfun(20, 20, 20);
    }

    if (dp[a][b][c] !== 0) {
      return dp[a][b][c];
    }

    if (a < b && b < c) {
      dp[a][b][c] =
        funfun(a, b, c - 1) + funfun(a, b - 1, c - 1) - funfun(a, b - 1, c);
    } else {
      dp[a][b][c] =
        funfun(a - 1, b, c) +
        funfun(a - 1, b - 1, c) +
        funfun(a - 1, b, c - 1) -
        funfun(a - 1, b - 1, c - 1);
    }

    return dp[a][b][c];
  }

  console.log(`w(${a}, ${b}, ${c}) = ${funfun(a, b, c)}`);
}

/**
 * ========================================================
 * @Title       : 9184
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\02_9184.spec.js
 * @Link        : https://www.acmicpc.net/problem/9184
 * @Description : 신나는 함수 실행
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 14:31:55
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('02_9184', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const a = 1;
    const b = 1;
    const c = 1;
    // 함수 실행
    solution(a, b, c);
    // 결과
    const result = 'w(1, 1, 1) = 2';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const a = 2;
    const b = 2;
    const c = 2;
    // 함수 실행
    solution(a, b, c);
    // 결과
    const result = 'w(2, 2, 2) = 4';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const a = 10;
    const b = 4;
    const c = 6;
    // 함수 실행
    solution(a, b, c);
    // 결과
    const result = 'w(10, 4, 6) = 523';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const a = 50;
    const b = 50;
    const c = 50;
    // 함수 실행
    solution(a, b, c);
    // 결과
    const result = 'w(50, 50, 50) = 1048576';

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
