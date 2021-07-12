function solution(k, num, links) {
  const tree = links.reduce((tree, v, i) => {
    tree[i] = {
      cost: num[i],
      l: v[0],
      r: v[1],
    };
    return tree;
  }, {});

  const n = num.length;
  const root = links.reduce((root, v) => {
    const [a, b] = v;
    if (a > 0) root -= a;
    if (b > 0) root -= b;
    return root;
  }, (n * (n - 1)) / 2);

  const go = limit => {
    const callStack = [root];
    const returnValues = {
      '-1': {
        cost: 0,
        cnt: 0,
      },
    };
    callStack.back = function () {
      return this[this.length - 1];
    };
    while (callStack.length) {
      const now = callStack.back(),
        { cost, l, r } = tree[now],
        lRes = returnValues[l],
        rRes = returnValues[r];

      if (!lRes) {
        callStack.push(l);
        continue;
      }
      if (!rRes) {
        callStack.push(r);
        continue;
      }
      callStack.pop();

      returnValues[now] = {
        cost,
        cnt: returnValues[l].cnt + returnValues[r].cnt,
      };
      const ret = returnValues[now];

      const underLimit = (...nodes) => {
        const sum = nodes.reduce((sum, v) => (sum += v.cost), 0);
        return sum <= limit;
      };

      if (underLimit(ret, lRes, rRes)) {
        ret.cost += lRes.cost + rRes.cost;
      } else if (underLimit(ret, lRes) || underLimit(ret, rRes)) {
        ret.cost += Math.min(lRes.cost, rRes.cost);
        ret.cnt += 1;
      } else {
        ret.cnt += 2;
      }
    }
    return returnValues[root];
  };

  const getAnswer = () => {
    let l = Math.max(...num),
      r = 11111 * n;
    let ans = r;
    while (l <= r) {
      const m = Math.floor((l + r) / 2);

      if (go(m).cnt <= k - 1) {
        r = m - 1;
        ans = Math.min(ans, m);
      } else {
        l = m + 1;
      }
    }
    return ans;
  };

  return getAnswer();
}
