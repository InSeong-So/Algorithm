let ip = (require('fs').readFileSync('dev/stdin', 'utf-8') + '')
  .trim()
  .split('\n');
let n = +ip[0],
  matrix = ip.slice(1).map(e => e.split(' ').map(e => +e)),
  t = [0],
  min = Infinity;

dfs(n / 2 - 1, 1);
console.log(min);

function dfs(left, st) {
  if (!left) {
    let df = getdf();
    if (min > df) min = df;
  }
  for (let i = st; i < n; i++) {
    t.push(i);
    dfs(left - 1, i + 1);
    t.pop();
  }
}
function getdf() {
  let v = [];
  for (let i = 1; i < n; i++) {
    if (!t.includes(i)) {
      v.push(i);
    }
  }
  let sum1 = 0,
    sum2 = 0;
  console.log(t, v);
  for (let i = 0; i < t.length; i++)
    for (let j = i + 1; j < t.length; j++) {
      sum1 += matrix[t[i]][t[j]] + matrix[t[j]][t[i]];
    }

  for (let i = 0; i < v.length; i++)
    for (let j = i + 1; j < v.length; j++) {
      sum2 += matrix[v[i]][v[j]] + matrix[v[j]][v[i]];
    }

  return Math.abs(sum1 - sum2);
}
