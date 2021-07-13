/*=======================================================================================
[수열 추측하기] : 순열, 이항계수 응용
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
     3   1   2   4
       4   3   6
         7   9
           16
N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하라.
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
=======================================================================================*/

// ▣ 입력설명
// 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다. N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

// ▣ 출력설명
// 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
// 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

// ▣ 입력예제 1
// 4 16

// ▣ 출력예제 1
// 3 1 2 4

function solution(n, f) {
  let answer = 0;
  // n이 10까지 들어오므로 10+1로 메모이제이션용 2차원 배열을 선언한다.
  let dy = Array.from(Array(11), () => Array(11).fill(0));
  // 순열 체크
  let check = Array.from({ length: n + 1 }, () => 0);
  // 순열 저장용
  let p = [];
  // 조합수
  let b = Array.from({ length: n }, () => 0);
  // 플래그 변수
  let flag = 0;

  function combination(n, r) {
    if (dy[n][r] > 0) return dy[n][r];
    if (n === r || r === 0) return 1;

    return (dy[n][r] = combination(n - 1, r - 1) + combination(n - 1, r));
  }

  // sum이 final 값이다.
  function DFS(v, sum) {
    if (flag === 1) return;
    // if(v === n) console.log(p);  // 순열 확인
    if (v === n && sum === f) {
      answer = p.slice();
      flag = 1;
    } else {
      for (let i = 1; i <= n; i++) {
        if (check[i] === 0) {
          check[i] = 1;
          p.push(i);
          DFS(v + 1, sum + b[v] * p[v]);
          check[i] = 0;
          p.pop();
        }
      }
    }
  }

  for (let i = 0; i < n; i++) {
    b[i] = combination(n - 1, i);
  }

  DFS(0, 0);

  return answer;
}

/**
 * ========================================================
 * @Title       : 13_수열_추측하기
 * @Path        : javascript\02_Solved\inflearn\h.recursion\13_수열_추측하기.spec.js
 * @Description :
 * @Date        : 2021-07-13 12:32:52
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('13_수열_추측하기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let k = 4;
    let n = 16;
    const result = [3, 1, 2, 4];

    // 테스트 결과 정의
    expect(solution(k, n)).toEqual(result);
  });
});
