function solution(block, board) {
  let answer = -1;

  let bl = [];
  switch (block) {
    case 0:
      {
        bl = [
          [1, 0, 0],
          [1, 0, 0],
          [1, 0, 0],
        ];
      }
      break;
    case 1:
      {
        bl = [
          [0, 0, 0],
          [0, 0, 0],
          [1, 1, 1],
        ];
      }
      break;
    case 2:
      {
        bl = [
          [0, 0, 0],
          [1, 0, 0],
          [1, 1, 0],
        ];
      }
      break;
    case 3:
      {
        bl = [
          [0, 0, 0],
          [0, 1, 0],
          [1, 1, 0],
        ];
      }
      break;
    case 4:
      {
        bl = [
          [0, 0, 0],
          [1, 1, 0],
          [0, 1, 0],
        ];
      }
      break;
    case 5:
      {
        bl = [
          [0, 0, 0],
          [1, 1, 0],
          [1, 0, 0],
        ];
      }
      break;
  }

  let n = board.length;
  let queue = [];
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 0 && bl[0][0] === 1) {
        board[i][j] = 1;
        let cnt = 0;
        queue.push([i, j]);
        while (queue.length) {
          let [x, y] = queue.shift();
          for (let k = 0; k < bl.length; k++) {
            let nx = x + bl[k][cnt];
            let ny = y + bl[k][cnt];
            // console.log(nx, ny);
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] === 0) {
              cnt++;
              board[nx][ny] = 2;
              queue.push([nx, ny]);
            } else {
              board[i][j] = 0;
            }
            if (cnt === 3) break;
          }
        }
      }
    }
  }

  let check = 1;
  let tempCnt = 0;
  for (let i = 0; i < board.length; i++) {
    tempCnt = 0;
    for (let item of board[i]) {
      if (item >= check) {
        tempCnt++;
      }
    }
    if (tempCnt === board.length) {
      answer++;
    }
  }

  return answer;
}

let k = 0;
let rates = [
  [1, 0, 0, 0],
  [1, 0, 0, 1],
  [1, 1, 0, 1],
  [1, 1, 0, 1],
];
console.log(solution(k, rates));
// describe('테스트', () => {
//   it('기본 테스트 케이스1', () => {
//     let k = 0;
//     let rates = [
//       [1, 0, 0, 0],
//       [1, 0, 0, 1],
//       [1, 1, 0, 1],
//       [1, 1, 0, 1],
//     ];
//     let result = 2;
//     expect(solution(k, rates)).toEqual(result);
//   });
// });
