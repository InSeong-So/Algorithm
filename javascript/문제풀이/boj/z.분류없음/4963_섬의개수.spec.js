/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);

const solution = (n, m, graph) => {
  const dx = [0, 0, -1, 1, -1, 1, 1, -1];
  const dy = [-1, 1, 0, 0, 1, 1, -1, -1];
  const visited = Array.from({ length: m }, () =>
    Array.from({ length: n }).fill(false),
  );

  const DFS = (x, y) => {
    for (let i = 0; i < 8; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];
      if (
        nx >= 0 &&
        nx < m &&
        ny >= 0 &&
        ny < n &&
        !visited[nx][ny] &&
        graph[nx][ny] === 1
      ) {
        visited[nx][ny] = true;
        DFS(nx, ny);
      }
    }
  };
  let answer = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (!visited[i][j] && graph[i][j] === 1) {
        visited[i][j] = true;
        DFS(i, j);
        answer++;
      }
    }
  }
  console.log(answer);
};

// while (true) {
//   const [n, m] = input
//     .shift()
//     .split(' ')
//     .map(e => Number(e));
//   const graph = Array.from({ length: m }, () => Array.from({ length: n }));
//   if (n === 0 && m === 0) {
//     break;
//   }
//   for (let i = 0; i < m; i++) {
//     const matrix = input
//       .shift()
//       .split(' ')
//       .map(e => Number(e));
//     graph[i] = matrix;
//   }
//   solution(n, m, graph);
// }

/**
 * ========================================================
 * @Title       : 4963_섬의개수
 * @Path        : javascript\문제풀이\boj\z.분류없음\4963_섬의개수.spec.js
 * @Link        : https://www.acmicpc.net/problem/4963_섬의개수
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-21 20:19:15
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('4963_섬의개수', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 1;
    const m = 1;
    const graph = [[0]];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 2;
    const m = 2;
    const graph = [
      [0, 1],
      [1, 0],
    ];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 3;
    const m = 2;
    const graph = [
      [1, 1, 1],
      [1, 1, 1],
    ];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 5;
    const m = 4;
    const graph = [
      [1, 0, 1, 0, 0],
      [1, 0, 0, 0, 0],
      [1, 0, 1, 0, 1],
      [1, 0, 0, 1, 0],
    ];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 3;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본5', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 5;
    const m = 4;
    const graph = [
      [1, 1, 1, 0, 1],
      [1, 0, 1, 0, 1],
      [1, 0, 1, 0, 1],
      [1, 0, 1, 1, 1],
    ];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본6', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const n = 5;
    const m = 5;
    const graph = [
      [1, 0, 1, 0, 1],
      [0, 0, 0, 0, 0],
      [1, 0, 1, 0, 1],
      [0, 0, 0, 0, 0],
      [1, 0, 1, 0, 1],
    ];
    // 함수 실행
    solution(n, m, graph);
    // 결과
    const result = 9;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
