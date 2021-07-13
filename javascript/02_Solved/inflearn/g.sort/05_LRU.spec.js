/*=======================================================================================
[Least Recently Used(카카오 캐시 문제 변형)]
캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가 필요할 바로 사용해서 처리속도를 높이는 장치이다.
워낙 비싸고 용량이 작아 효율적으로 사용해야 한다. 컴퓨터의 캐시메모리 사용 규칙은 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used의 약자로 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하는 알고리즘이다.
만약 캐시의 사이즈가 5이고 작업이 [2|3|1|6|7] 순으로 저장되어 있을 때(맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업)

1) Cache Miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작업을 CPU가 사용한다면
Cache miss가 되고 모든 작업이 뒤로 밀리고 5번작업은 캐시의 맨 앞에 위치한다. 
[2|3|1|6|7] ---> [5|2|3|1|6]
(7번 작업은 캐시에서 삭제)

2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면
Cache Hit가 되고 63번 앞에 있는 5, 2번 작업은 한 칸 뒤로 밀리고, 3번이 맨 앞으로 위치하게 된다. 
[5|2|3|1|6] ---> [3|5|2|1|6]

캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 
N개의 작업을 처리한 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하라.
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
// 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~ 100 이다.

// ▣ 출력설명
// 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력한다.

// ▣ 입력예제 1
// 5 9
// 1 2 3 2 6 2 3 5 7

// ▣ 출력예제 1
// 1 0 0 0 0
// 2 1 0 0 0
// 3 2 1 0 0
// 2 3 1 0 0
// 6 2 3 1 0
// 2 6 3 1 0
// 3 2 6 1 0
// 5 3 2 6 1
// 7 5 3 2 6

// 삽입정렬 스타일
function solution(size, arr) {
  let answer = Array.from({ length: size }, () => 0);

  arr.forEach(e => {
    let pos = -1;
    for (let i = 0; i < size; i++) {
      if (e === answer[i]) {
        pos = i;
      }
    }
    // miss
    if (pos === -1) {
      for (let i = size - 1; i >= 1; i--) {
        // 앞을 뒤에 있는 것으로 땡긴다.
        answer[i] = answer[i - 1];
      }
    } else {
      // hit된 지점부터 돈다.
      for (let i = pos; i >= 1; i--) {
        // 앞을 뒤에 있는 것으로 땡긴다.
        answer[i] = answer[i - 1];
      }
    }
    // 앞에 삽입
    answer[0] = e;
  });

  return answer;
}

// 내장함수 사용
function solution2(size, arr) {
  let answer = [];

  arr.forEach(e => {
    let pos = -1;
    for (let i = 0; i < size; i++) {
      if (e === answer[i]) {
        pos = i;
      }
    }
    // miss
    if (pos === -1) {
      answer.unshift(e);
      if (answer.length > size) {
        answer.pop();
      }
    } else {
      answer.splice(pos, 1);
      answer.unshift(e);
    }
  });

  return answer;
}

/**
 * ========================================================
 * @Title       : 05_LRU
 * @Path        : javascript\02_Solved\inflearn\g.sortingANDgreedANDdecision\05_LRU.spec.js
 * @Description :
 * @Date        : 2021-07-12 22:00:01
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('05_LRU', () => {
  // 테스트 케이스명
  it('기본1:for문으로 캐시를 순회하기', () => {
    // 파라미터 정의
    let k = 5;
    let arr = [1, 2, 3, 2, 6, 2, 3, 5, 7];
    const result = [7, 5, 3, 2, 6];

    // 테스트 결과 정의
    expect(solution(k, arr)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본1:unshift, pop을 사용하기', () => {
    // 파라미터 정의
    let k = 5;
    let arr = [1, 2, 3, 2, 6, 2, 3, 5, 7];
    const result = [7, 5, 3, 2, 6];

    // 테스트 결과 정의
    expect(solution2(k, arr)).toEqual(result);
  });
});
