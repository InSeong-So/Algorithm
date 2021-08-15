var n = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(function (e) {
    return e.split(' ').map(function (e) {
      return parseInt(e);
    });
  });
n.pop();
console.log(
  n
    .map(function (e) {
      if (e[0] % e[1] === 0) {
        return 'multiple';
      } else if (e[1] % e[0] === 0) {
        return 'factor';
      } else {
        return 'neither';
      }
    })
    .join('\n'),
);
