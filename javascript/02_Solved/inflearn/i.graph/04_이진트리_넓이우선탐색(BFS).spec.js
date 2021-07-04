/*=======================================================================================
[ 이진트리 넓이우선탐색(BFS) ]
아래 그림과 같은 이진트리를 넓이우선탐색하라.
=======================================================================================*/

//       1
//   2       3
// 4   5   6   7

// 넓이 우선 탐색 : 1 2 3 4 5 6 7

// 큐를 사용하여 해결
// 상태 트리를 레벨 탐색하며 최단거리에 사용된다.
function solution() {
  let answer = '';

  let queue = [];
  queue.push(1);
  while (queue.length) {
    let v = queue.shift();
    answer += v + ' ';
    for (let nv of [v * 2, v * 2 + 1]) {
      if (nv > 14) continue;
      queue.push(nv);
    }
  }

  return answer;
}

console.log(solution());
