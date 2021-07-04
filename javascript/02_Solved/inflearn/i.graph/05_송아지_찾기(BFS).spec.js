/*=======================================================================================
[송아지 찾기(BFS : 상태트리탐색)]
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다. 
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하라.
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다.
// 직선의 좌표 점은 1부터 10,000까지이다.

// ▣ 출력설명
// 점프의 최소횟수를 구한다. 답은 1 이상이다.

// ▣ 입력예제 1
// 5 14

// ▣ 출력예제 1
// 3

// ▣ 입력예제 2
// 8 3

// ▣ 출력예제 2
// 5

function solution2(s, e) {
  let answer = 0;
  let check = Array.from({ length: 10001 }, () => 0);
  let distance = Array.from({ length: 10001 }, () => 0);
  let queue = [];

  check[s] = 1;
  queue.push(s);

  distance[s] = 0;

  while (queue.length) {
    let x = queue.shift();
    for (let nx of [x - 1, x + 1, x + 5]) {
      if (nx === e) {
        return distance[x];
      }
      if (nx > 0 && nx <= 10000 && check[nx] === 0) {
        check[nx] = 1;
        queue.push(nx);
        // 레벨 값을 구한다(여기서는 거리)
        distance[nx] = distance[x] + 1;
      }
    }
  }

  return answer;
}

// 레벨로 계산하기
function solution(s, e) {
  let answer = 0;
  let check = Array.from({ length: 10001 }, () => 0);
  let queue = [];
  queue.push(s);
  check[s] = 1;
  let L = 0;
  while (queue.length) {
    let len = queue.length;
    for (let i = 0; i < len; i++) {
      let x = queue.shift();
      for (let nx of [x - 1, x + 1, x + 5]) {
        if (nx === e) {
          return L + 1;
        }
        if (nx > 0 && nx <= 10000 && check[nx] === 0) {
          check[nx] = 1;
          queue.push(nx);
        }
      }
    }
    L++;
  }
  return answer;
}

console.log(solution(8, 3));
