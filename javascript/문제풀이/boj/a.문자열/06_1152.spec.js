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
function solution(input) {
  input = input.trim().split(' ');
  if (input[0] === '') {
    return 0;
  }
  return input.length;
}

// console.log('%d', solution(input));

/**
 * ========================================================
 * @Title       : 1152
 * @Path        : javascript\문제풀이\boj\a.문자열\01_1152.spec.js
 * @Link        : https://www.acmicpc.net/problem/1152
 * @Description : 단어의 개수
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-12 13:23:04
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('01_1152', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'The Curious Case of Benjamin Button';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 6;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = ' Mazatneunde Wae Teullyeoyo';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = 'Teullinika Teullyeotzi ';
    // 함수 실행
    console.log(solution(input));
    // 결과
    const result = 2;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
