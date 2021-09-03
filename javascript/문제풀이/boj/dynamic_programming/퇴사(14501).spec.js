/**
 * 입력
 */
const fs = require('fs');
const os = require('os');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(os.EOL);
const day = Number(input[0]);
const schedules = input.slice(1).map(e => e.split(' ').map(e2 => Number(e2)));

/**
 * Solve 함수
 */
const solution = (day, schedules) => {
  let dp = Array.from({ length: day + 1 }, () => 0);
  for (let i = day - 1; i >= 0; i--) {
    const [takes, cost] = schedules[i];
    const now = i + takes;
    if (now > day) {
      dp[i] = dp[i + 1];
    } else {
      dp[i] = Math.max(dp[i + 1], cost + dp[now]);
    }
  }
  console.log(Math.max(...dp));
};

solution(day, schedules);

/**
 * ========================================================
 * @Title       : 14501
 * @Path        : javascript\문제풀이\boj\z.분류없음\14501_퇴사.spec.js
 * @Link        : https://www.acmicpc.net/problem/14501
 * @Description : 퇴사
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-20 00:50:44
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('14501_퇴사', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const day = 7;
    const schedules = [
      [3, 10],
      [5, 20],
      [1, 10],
      [1, 20],
      [2, 15],
      [4, 40],
      [2, 200],
    ];
    // 함수 실행
    solution(day, schedules);
    // 결과
    const result = 45;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const day = 10;
    const schedules = [
      [1, 1],
      [1, 2],
      [1, 3],
      [1, 4],
      [1, 5],
      [1, 6],
      [1, 7],
      [1, 8],
      [1, 9],
      [1, 10],
    ];
    // 함수 실행
    solution(day, schedules);
    // 결과
    const result = 55;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const day = 10;
    const schedules = [
      [5, 10],
      [5, 9],
      [5, 8],
      [5, 7],
      [5, 6],
      [5, 10],
      [5, 9],
      [5, 8],
      [5, 7],
      [5, 6],
    ];
    // 함수 실행
    solution(day, schedules);
    // 결과
    const result = 20;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const day = 10;
    const schedules = [
      [5, 50],
      [4, 40],
      [3, 30],
      [2, 20],
      [1, 10],
      [1, 10],
      [2, 20],
      [3, 30],
      [4, 40],
      [5, 50],
    ];
    // 함수 실행
    solution(day, schedules);
    // 결과
    const result = 90;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('반례1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const day = 1;
    const schedules = [[2, 5]];
    // 함수 실행
    solution(day, schedules);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
