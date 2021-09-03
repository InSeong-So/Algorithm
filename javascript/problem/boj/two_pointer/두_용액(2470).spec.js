/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// let input = fs.readFileSync('/dev/stdin').toString().split(os.EOL);

// solution(input);

/**
 * Solve 함수
 */
const solution = input => {
  console.log(input);
};

/**
 * ========================================================
 * @Title       : 두_용액
 * @Path        : javascript/문제풀이/boj/two_pointer/두_용액(2470).spec.js
 * @Link        : https://www.acmicpc.net/problem/2470
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-03 23:53:55
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('두_용액(2470)', () => {
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
