/*=======================================================================================
[이진트리 순회] : 깊이우선탐색
아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
          1
      2       3
    4   5   6   7
전위순회 출력 : 1 2 4 5 3 6 7   // 부모 왼쪽 오른쪽 순
중위순회 출력 : 4 2 5 1 6 3 7   // 왼쪽 부모 오른쪽 순
후위순회 출력 : 4 5 2 6 7 3 1   // 왼쪽 오른쪽 부모 순
=======================================================================================*/

// 전위순회
function solution1(n) {
  let answer = '';

  function DFS(v) {
    if (v > 7) return;

    console.log(v);
    DFS(v * 2);
    DFS(v * 2 + 1);
  }

  DFS(n);

  return answer;
}

// 중위순회
function solution2(n) {
  let answer = '';

  function DFS(v) {
    if (v > 7) return;

    DFS(v * 2);
    console.log(v);
    DFS(v * 2 + 1);
  }

  DFS(n);

  return answer;
}

// 후위순회
function solution3(n) {
  let answer = '';

  function DFS(v) {
    if (v > 7) return;

    DFS(v * 2);
    DFS(v * 2 + 1);
    console.log(v);
  }

  DFS(n);

  return answer;
}

solution1(1);
console.log('===============');
solution2(1);
console.log('===============');
solution3(1);
