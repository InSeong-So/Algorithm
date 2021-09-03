function solution(board) {
  const n = board.length;
  const Q = [[0, 0, '', 0]];
  const directionAdds = [0, 1, 3];

  function checkPush([x, y]) {
    return (
      x >= 0 &&
      x < n &&
      y >= 0 &&
      y < n &&
      !(x === 0 && y === 0) &&
      board[y][x] !== 1
    );
  }

  while (Q.length) {
    let [x, y, direction, price] = Q[0];
    if (board[y][x] >= price || board[y][x] === 0) {
      board[y][x] = price;
      directionAdds.forEach(n => {
        let D = (direction + n) % 4;
        let a = D === 0 ? x + 1 : D === 2 ? x - 1 : x;
        let b = D === 1 ? y + 1 : D === 3 ? y - 1 : y;
        if (checkPush([a, b])) {
          Q.push([
            a,
            b,
            D,
            n === 0 || direction === '' ? price + 100 : price + 600,
          ]);
        }
      });
    }
    Q.shift();
  }
  return board[n - 1][n - 1];
}
