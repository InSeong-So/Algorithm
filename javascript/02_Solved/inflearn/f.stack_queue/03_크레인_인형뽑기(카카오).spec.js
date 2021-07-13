/*=======================================================================================
[크레인 인형뽑기 게임]

https://programmers.co.kr/learn/courses/30/lessons/64061
=======================================================================================*/

function solution(board, moves) {
  let answer = 0;
  let stack = [];
  moves.forEach(pos => {
    for (let i = 0; i < board.length; i++) {
      // 인형을 만남
      if (board[i][pos - 1] !== 0) {
        // 인형 꺼내기
        let temp = board[i][pos - 1];
        // 인형을 꺼냈으니 해당 자리를 0으로 변경
        board[i][pos - 1] = 0;
        // 인형이 동일하다면 터트리고 answer 더하기
        if (temp === stack[stack.length - 1]) {
          stack.pop();
          answer += 2;
        } else {
          stack.push(temp);
        }
        // 인형을 하나만 꺼내야하므로 break;
        break;
      }
    }
  });
  return answer;
}

/**
 * ========================================================
 * @Title       : 03_크레인_인형뽑기(카카오)
 * @Path        : javascript\02_Solved\inflearn\f.stackANDqueue\03_크레인_인형뽑기(카카오).spec.js
 * @Description :
 * @Date        : 2021-07-12 21:34:17
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('03_크레인_인형뽑기(카카오)', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let a = [
      [0, 0, 0, 0, 0],
      [0, 0, 1, 0, 3],
      [0, 2, 5, 0, 1],
      [4, 2, 4, 4, 2],
      [3, 5, 1, 3, 1],
    ];

    let b = [1, 5, 3, 5, 1, 2, 1, 4];
    const result = 4;

    // 테스트 결과 정의
    expect(solution(a, b)).toEqual(result);
  });
});
