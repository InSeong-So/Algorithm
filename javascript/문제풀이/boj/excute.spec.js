let n = 0;
let dp = Array.from({ length: 10000 }, () => 0);
while (n < 10000) {
  dp[recursion(n)] = 1;
  n++;
}

function recursion(n) {
  let temp = 0;
  for (let s of n.toString()) {
    temp += Number(s);
  }

  return n + temp;
}

dp.forEach((e, i) => {
  if (e == 0) {
    console.log(i);
  }
});
