// https://programmers.co.kr/learn/courses/30/lessons/42627

function solution(jobs) {
  let total = jobs.length;
  let answer = 0;
  let tick = 0; // 흐르는 시간
  let queue = [];
  while (true) {
    // 1. (jobs가 있을 때) tick보다 같거나 작은 작업 모두 추출 후 queue에 삽입
    let index = 0;
    while (true) {
      if (index >= jobs.length) break;
      if (jobs[index][0] <= tick) {
        // 요청이 들어온 작업
        queue.push(jobs.splice(index, 1)[0]);
      } else {
        // 요청 전 작업
        index++;
      }
    }

    // 3. queue와 jobs가 0이면 끝
    if (queue.length === 0) {
      if (jobs.length === 0) {
        break;
      } else {
        tick++;
      }
    } else {
      // 2. (queue가 있을 때) queue에서 작업량이 가장 작은 작업 수행
      let minIndex = 0;
      for (let i = 1; i < queue.length; i++) {
        if (queue[minIndex][1] > queue[i][1]) minIndex = i;
      }

      // 2.1 수행한 시간 만큼 tick 증가
      tick += queue[minIndex][1];

      // 2.2 answer += tick - 수행한 작업의 작업 처리 요청 시간
      answer += tick - queue[minIndex][0];

      // 2.3 queue에서 해당 job 삭제
      queue.splice(minIndex, 1);
    }
  }

  return Math.floor(answer / total);
}

let arr = [
  [0, 3],
  [1, 9],
  [2, 6],
];

solution(arr);

/**
 * ========================================================
 * @Title       : 디스크_컨트롤러
 * @Path        : javascript\02_Solved\programmers\디스크_컨트롤러.spec.js
 * @Description :
 * @Date        : 2021-07-12 17:24:56
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
// describe('디스크_컨트롤러', () => {
//   // 테스트 케이스명
//   it('기본1', () => {
//     // 파라미터 정의
//     let arr = [
//       [0, 10],
//       [2, 10],
//       [9, 10],
//       [15, 2],
//     ];
//     const result = 14;

//     // 테스트 결과 정의
//     expect(solution(arr)).toEqual(result);
//   });

//   // 테스트 케이스명
//   it('기본1', () => {
//     // 파라미터 정의
//     let arr = [
//       [0, 10],
//       [2, 12],
//       [9, 19],
//       [15, 17],
//     ];
//     const result = 25;

//     // 테스트 결과 정의
//     expect(solution(arr)).toEqual(result);
//   });

//   // 테스트 케이스명
//   it('기본1', () => {
//     // 파라미터 정의
//     let arr = [
//       [0, 3],
//       [1, 9],
//       [2, 6],
//     ];
//     const result = 9;

//     // 테스트 결과 정의
//     expect(solution(arr)).toEqual(result);
//   });

//   // 테스트 케이스명
//   it('기본1', () => {
//     // 파라미터 정의
//     let arr = [[0, 1]];
//     const result = 1;

//     // 테스트 결과 정의
//     expect(solution(arr)).toEqual(result);
//   });
// });
