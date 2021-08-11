function solution(places) {
  let answer = Array(places.length).fill(0);
  // string을 배열로 변환
  places = places.map(p => p.map(i => i.split('')));

  let dx = [-1, 0, 1, 0];
  let dy = [0, 1, 0, -1];

  for (let i = 0; i < places.length; i++) {
    DFS(i);
  }

  function DFS(lc) {
    answer[lc] = 1;
    let place = places[lc];
    for (let i = 0; i < 5; i++) {
      for (let j = 0; j < 5; j++) {
        if (place[i][j] !== 'P') continue;
        for (let k = 0; k < 4; k++) {
          let nx = i + dx[k];
          let ny = j + dy[k];
          if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
            if (place[nx][ny] === 'P') {
              answer[lc] = 0;
              return;
            } else if (place[nx][ny] === 'O') {
              for (let k2 = 0; k2 < 4; k2++) {
                let nx2 = nx + dx[k2];
                let ny2 = ny + dy[k2];
                if (nx2 >= 0 && nx2 < 5 && ny2 >= 0 && ny2 < 5) {
                  if (place[nx2][ny2] === 'P' && nx2 !== i && ny2 !== j) {
                    answer[lc] = 0;
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 02_거리_두기_확인하기
 * @Path        : javascript\02_Solved\kakao\2021_internship\02_거리_두기_확인하기.spec.js
 * @Description :
 * @Date        : 2021-07-09 15:46:28
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('02_거리_두기_확인하기', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let places = [
      ['POOOP', 'OXXOX', 'OPXPX', 'OOXOX', 'POXXP'],
      ['POOPX', 'OXPXP', 'PXXXO', 'OXXXO', 'OOOPP'],
      ['PXOPX', 'OXOXP', 'OXPXX', 'OXXXP', 'POOXX'],
      ['OOOXX', 'XOOOX', 'OOOXX', 'OXOOX', 'OOOOO'],
      ['PXPXP', 'XPXPX', 'PXPXP', 'XPXPX', 'PXPXP'],
      ['OOPOO', 'OPOOO', 'OOOOO', 'OOOOO', 'OOOOO'],
      ['OOPOO', 'OXOOO', 'OOOOO', 'OOOOO', 'OOOOO'],
      ['OPXOO', 'PXOOO', 'OOOOO', 'OOOOO', 'OOOOO'],
    ];
    const result = [1, 0, 1, 1, 1, 0, 1, 0];

    // 테스트 결과 정의
    expect(solution(places)).toEqual(result);
  });
});
