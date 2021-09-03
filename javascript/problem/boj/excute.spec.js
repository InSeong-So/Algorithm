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
console.log(nums);
