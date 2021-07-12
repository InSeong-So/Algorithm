// https://programmers.co.kr/learn/courses/30/lessons/43162

/* DFS를 사용하여 해결한다. */
function solution(n, computers) {
  let answer = 0;

  let check = Array(n).fill(0);

  function DFS(index) {
    check[index] = 1;

    for (let j = 0; j < computers[index].length; j++) {
      if (index !== j && computers[index][j] === 1 && check[j] === 0) {
        DFS(j);
      }
    }
  }

  for (let i = 0; i < check.length; i++) {
    if (check[i] === 0) {
      DFS(i);
      answer++;
    }
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 네트워크
 * @Path        : javascript\02_Solved\programmers\네트워크.spec.js
 * @Description :
 * @Date        : 2021-07-07 22:44:38
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('네트워크', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let k = 3;
    let arr = [
      [1, 1, 0],
      [1, 1, 0],
      [0, 0, 1],
    ];
    const result = 2;

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });

  it('기본1', () => {
    // 파라미터 정의
    let k = 3;
    let arr = [
      [1, 1, 0],
      [1, 1, 1],
      [0, 1, 1],
    ];
    const result = 1;

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });
});
