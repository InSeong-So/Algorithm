const input = require('fs')
  .readFileSync('dev/stdin')
  .toString()
  .trim()
  .split(require('os').EOL);
const N = +input[0];
const nums = input[1]
  .split(' ')
  .map(e => +e)
  .sort((a, b) => a - b);
const X = +input[2];

let left = 0;
let right = N - 1;

let answer = 0;
let sum = 0;
while (left < right) {
  sum = nums[left] + nums[right];
  if (sum === X) {
    answer++;
  } else if (sum < X) {
    left++;
    continue;
  }
  right--;
}

console.log(answer);
