function solution(s) {
  const dict = {};

  for (const c of s) {
    if (dict.hasOwnProperty(c)) {
      dict[c]++;
    } else {
      dict[c] = 1;
    }
  }
  let idx = Number.MAX_SAFE_INTEGER;
  for (let i in dict) {
    if (dict[i] == 1 && s.indexOf(i) < idx) {
      idx = s.indexOf(i);
    }
  }
  console.log(idx + 1);
}

solution('hackthegame');
