function solution(n, path, order) {
  const graph = Array.from({ length: n }, () => []);

  for (const [u, v] of path) {
    graph[u].push(v);
    graph[v].push(u);
  }

  const tree = Array.from({ length: n }, () => []);
  for (const [u, v] of order) {
    tree[v].push(u);
  }

  const constructTree = (u = 0, p = -1) => {
    for (const v of graph[u]) {
      if (v === p) {
        continue;
      }

      tree[v].push(u);
      constructTree(v, u);
    }
  };

  constructTree();

  const colors = new Array(n);
  const DFS = start => {
    const stack = [[start, false]];

    while (stack.length) {
      const [u, isEnd] = stack[stack.length - 1];
      stack.pop();

      if (isEnd) {
        colors[u] = 2;
        continue;
      }

      stack.push([u, true]);
      colors[u] = 1;
      for (const v of tree[u]) {
        const color = colors[v];
        if (color === 1) {
          return false;
        } else if (!color) {
          stack.push([v, false]);
        }
      }
    }

    return true;
  };
  for (let i = 0; i < n; ++i) {
    if (!DFS(i)) {
      return false;
    }
  }

  return true;
}
