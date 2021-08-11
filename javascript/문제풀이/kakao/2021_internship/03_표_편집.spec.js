// 세그먼트 트리, 팬윅 트리
function solution(n, k, cmd) {
  let answer = '';
  // 선택된 행
  let selector = [];
  // 작업할 표
  let workTable = new Array(n).fill().map((elem, i) => {
    const obj = {
      v: i,
      prev: i == 0 ? null : i - 1,
      next: i == n - 1 ? null : i + 1,
    };
    return obj;
  });

  for (let i = 0; i < cmd.length; i++) recursion(cmd[i]);
  for (let i = 0; i < n; i++) answer += workTable[i].v == i ? 'O' : 'X';

  function recursion(cmds) {
    switch (cmds[0]) {
      case 'Z':
        {
          let z = selector.pop();
          workTable[z].v = z;
          if (workTable[z].prev === null) {
            workTable[workTable[z].next].prev = z;
          } else if (workTable[z].next === null) {
            workTable[workTable[z].prev].next = z;
          } else {
            workTable[workTable[z].prev].next = z;
            workTable[workTable[z].next].prev = z;
          }
        }
        break;
      case 'C':
        {
          selector.push(k);
          workTable[k].v = null;
          if (workTable[k].prev === null) {
            workTable[workTable[k].next].prev = null;
            k = workTable[k].next;
          } else if (workTable[k].next === null) {
            workTable[workTable[k].prev].next = null;
            k = workTable[k].prev;
          } else {
            workTable[workTable[k].prev].next = workTable[k].next;
            workTable[workTable[k].next].prev = workTable[k].prev;
            k = workTable[workTable[k].prev].next;
          }
        }
        break;
      case 'D':
        {
          let move = cmds.split(' ')[1];
          for (let i = 0; i < move; i++) {
            k = workTable[k].next;
          }
        }
        break;
      case 'U':
        {
          let move = cmds.split(' ')[1];
          for (let i = 0; i < move; i++) {
            k = workTable[k].prev;
          }
        }
        break;
    }
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 03_표_편집
 * @Path        : javascript\02_Solved\kakao\2021_internship\03_표_편집.spec.js
 * @Description : 세그먼트 트리 알고리즘
 * @Date        : 2021-07-09 13:30:13
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('03_표_편집', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    const n = 8;
    const k = 2;
    const cmd = ['D 2', 'C', 'U 3', 'C', 'D 4', 'C', 'U 2', 'Z', 'Z'];
    const result = 'OOOOXOOO';

    // 테스트 결과 정의
    expect(solution(n, k, cmd)).toEqual(result);
  });

  it('기본2', () => {
    // 파라미터 정의
    const n = 8;
    const k = 2;
    const cmd = [
      'D 2',
      'C',
      'U 3',
      'C',
      'D 4',
      'C',
      'U 2',
      'Z',
      'Z',
      'U 1',
      'C',
    ];
    const result = 'OOXOXOOO';

    // 테스트 결과 정의
    expect(solution(n, k, cmd)).toEqual(result);
  });
});
