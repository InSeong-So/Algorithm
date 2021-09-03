/**
 * 입력
 */
// const fs = require('fs');
// const os = require('os');
// const input = fs.readFileSync('dev/stdin').toString().trim().split(os.EOL);
// const [N, M] = input[0].split(' ').map(e => Number(e));
// const matrix = input.slice(1).map(e => e.split(''));

/**
 * Solve 함수
 */
const solution = (N, M, matrix) => {
  // 직선방향 끝까지 가기
  const move = (x, y, dx, dy) => {
    // 이동 횟수
    let cnt = 0;
    // 이동 중간에 골 지점이 있다면 공은 사라진다.
    while (matrix[x + dx][y + dy] !== '#' && matrix[x][y] !== 'O') {
      x += dx;
      y += dy;
      cnt++;
    }
    return [x, y, cnt];
  };

  // 탐색
  const BFS = (x, y, xx, yy) => {
    let queue = [];
    queue.push([x, y, xx, yy, 1]);
    while (queue.length > 0) {
      const [lx, ly, lxx, lyy, cnt] = queue.shift();
      if (cnt > 10) {
        return -1;
      } else {
        for (let i = 0; i < 4; i++) {
          let [nx, ny, nc] = move(lx, ly, dx[i], dy[i]);
          let [nxx, nyy, ncc] = move(lxx, lyy, dx[i], dy[i]);
          if (matrix[nxx][nyy] !== 'O') {
            if (matrix[nx][ny] === 'O') {
              return cnt;
            }

            if (nx === nxx && ny === nyy) {
              if (nc > ncc) {
                nx -= dx[i];
                ny -= dy[i];
              } else {
                nxx -= dx[i];
                nyy -= dy[i];
              }
            }

            if (!visited[nx][ny][nxx][nyy]) {
              visited[nx][ny][nxx][nyy] = true;

              queue.push([nx, ny, nxx, nyy, cnt + 1]);
            }
          }
        }
      }
    }
    return -1;
  };

  const dx = [0, 0, -1, 1];
  const dy = [-1, 1, 0, 0];

  const visited = Array.from({ length: N }, () =>
    Array.from({ length: M }, () =>
      Array.from({ length: N }, () => Array.from({ length: M }, () => false)),
    ),
  );

  //
  let red = null;
  let blue = null;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (matrix[i][j] === 'R') {
        red = [i, j];
      }
      if (matrix[i][j] === 'B') {
        blue = [i, j];
      }
      if (red && blue) break;
    }
  }

  const [x, y] = red;
  const [xx, yy] = blue;
  visited[x][y][xx][yy] = true;
  console.log(BFS(x, y, xx, yy));
  //
};

// solution(N, M, matrix);

/**
 * ========================================================
 * @Title       : 13460
 * @Path        : javascript\문제풀이\boj\z.분류없음\13460_구슬탈출2.spec.js
 * @Link        : https://www.acmicpc.net/problem/13460
 * @Description : 구슬 탈출2
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-08-24 14:32:56
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('13460_구슬탈출2', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 5;
    const M = 5;
    let input = ['#####', '#..B#', '#.#.#', '#RO.#', '#####'];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본2', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 7;
    const M = 7;
    let input = [
      '#######',
      '#...RB#',
      '#.#####',
      '#.....#',
      '#####.#',
      '#O....#',
      '#######',
    ];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = 5;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본3', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 7;
    const M = 7;
    let input = [
      '#######',
      '#..R#B#',
      '#.#####',
      '#.....#',
      '#####.#',
      '#O....#',
      '#######',
    ];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = 5;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본4', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 10;
    const M = 10;
    let input = [
      '##########',
      '#R#...##B#',
      '#...#.##.#',
      '#####.##.#',
      '#......#.#',
      '#.######.#',
      '#.#....#.#',
      '#.#.#.#..#',
      '#...#.O#.#',
      '##########',
    ];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = -1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본5', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 3;
    const M = 7;
    let input = ['#######', '#R.O.B#', '#######'];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = 1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본6', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 10;
    const M = 10;
    let input = [
      '##########',
      '#R#...##B#',
      '#...#.##.#',
      '#####.##.#',
      '#......#.#',
      '#.######.#',
      '#.#....#.#',
      '#.#.##...#',
      '#O..#....#',
      '##########',
    ];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = 7;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
  // 테스트 케이스명
  it('기본7', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const N = 3;
    const M = 10;
    let input = ['##########', '#.O....RB#', '##########'];
    const matrix = input.map(e => e.split(''));
    // 함수 실행
    solution(N, M, matrix);
    // 결과
    const result = -1;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
