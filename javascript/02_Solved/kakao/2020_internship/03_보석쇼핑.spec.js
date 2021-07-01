function solution(gems) {
  const gemVarietyCounts = new Set(gems).size;

  const gemMap = new Map();
  const gemLengths = [];
  gems.forEach((gem, i) => {
    gemMap.delete(gem);
    gemMap.set(gem, i);
    if (gemMap.size === gemVarietyCounts) {
      gemLengths.push([gemMap.values().next().value + 1, i + 1]);
    }
  });

  gemLengths.sort((a, b) => {
    if (a[1] - a[0] === b[1] - b[0]) {
      return a[1] - b[1];
    }
    return a[1] - a[0] - (b[1] - b[0]);
  });

  return gemLengths[0];
}
