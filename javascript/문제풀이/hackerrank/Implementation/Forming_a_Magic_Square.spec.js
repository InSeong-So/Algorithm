/*
 * Complete the 'formingMagicSquare' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY s as parameter.
 */

function formingMagicSquare(s) {
  // Write your code here
  let magicSquare = [
    [8, 1, 6, 3, 5, 7, 4, 9, 2],
    [6, 1, 8, 7, 5, 3, 2, 9, 4],
    [2, 7, 6, 9, 5, 1, 4, 3, 8],
    [4, 3, 8, 9, 5, 1, 2, 7, 6],
    [2, 9, 4, 7, 5, 3, 6, 1, 8],
    [4, 9, 2, 3, 5, 7, 8, 1, 6],
    [8, 3, 4, 1, 5, 9, 6, 7, 2],
    [6, 7, 2, 1, 5, 9, 8, 3, 4],
  ];

  s = s.flat();

  let answer = Infinity;

  for (let i = 0; i < magicSquare.length; i++) {
    let cnt = 0;

    for (let j = 0; j < 9; j++) {
      cnt += Math.abs(magicSquare[i][j] - s[j]);
    }

    if (answer > cnt) {
      answer = cnt;
    }
  }

  return answer;
}
