/**
 *
 * [0, 0], [0, 1], [0, 2]     0 1 2
 * [1, 0], [1, 1], [1, 2]     1 2 3
 * [2, 0], [2, 1], [2, 2]     2 3 4
 * *    ,  [3, 1], #            4
 *
 */

function solution(numbers, hand) {
  hand = hand === 'right' ? 'R' : 'L';
  let position = [1, 4, 4, 4, 3, 3, 3, 2, 2, 2];
  let h = { L: [1, 1], R: [1, 1] };
  return numbers
    .map(x => {
      if (/[147]/.test(x)) {
        h.L = [position[x], 1];
        return 'L';
      }
      if (/[369]/.test(x)) {
        h.R = [position[x], 1];
        return 'R';
      }
      let distL = Math.abs(position[x] - h.L[0]) + h.L[1];
      let distR = Math.abs(position[x] - h.R[0]) + h.R[1];
      if (distL === distR) {
        h[hand] = [position[x], 0];
        return hand;
      }
      if (distL < distR) {
        h.L = [position[x], 0];
        return 'L';
      }
      h.R = [position[x], 0];
      return 'R';
    })
    .join('');
}
