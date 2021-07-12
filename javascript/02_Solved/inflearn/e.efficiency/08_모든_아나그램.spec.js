/*=======================================================================================
[모든 아나그램 찾기]
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하라.
아나그램 판별시 대소문자가 구분되며 부분문자열은 연속된 문자열이어야 한다.
=======================================================================================*/

// ▣ 입력설명
// S문자열과 T문자열이 입력된다.
// S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같다.

// ▣ 출력설명
// S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력한다.

// ▣ 입력예제 1
// bacaAacba
// abc

// ▣ 출력예제 1
// 3
// {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램이다.

/* 집합 자료구조, 슬라이딩 윈도우, 투 포인터 전부 사용해서 해결하기(O(n)) */
function solution(s, t) {
  let answer = 0;
  let target = new Map();
  let compare = new Map();

  for (let c of t) {
    if (target.has(c)) {
      target.set(c, target.get(c) + 1);
    } else {
      target.set(c, 1);
    }
  }

  // 최초 길이 설정, 슬라이딩 윈도우 알고리즘을 적용할 것이므로 타겟 문자열의 길이보다 1 적어야 한다.
  const tLen = t.length - 1;
  for (let i = 0; i < tLen; i++) {
    if (compare.has(s[i])) {
      compare.set(s[i], compare.get(s[i]) + 1);
    } else {
      compare.set(s[i], 1);
    }
  }

  let left = 0;
  for (let right = tLen; right < s.length; right++) {
    // 추가
    if (compare.has(s[right])) {
      compare.set(s[right], compare.get(s[right]) + 1);
    } else {
      compare.set(s[right], 1);
    }

    // 비교
    if (compareMaps(target, compare)) {
      answer++;
    }

    // 빼기 : 현재 left가 가리키는것을 삭제해야함
    compare.set(s[left], compare.get(s[left]) - 1);
    if (compare.get(s[left]) === 0) {
      compare.delete(s[left]);
    }
    left++;
  }

  // 두 집합 비교
  function compareMaps(target, compare) {
    // 아나그램이라면 key의 size가 같아야 한다.
    if (target.size !== compare.size) {
      return false;
    }

    for (let [k, v] of compare) {
      if (!target.has(k) || target.get(k) !== v) {
        return false;
      }
    }

    return true;
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 08_모든_아나그램
 * @Path        : javascript\02_Solved\inflearn\e.efficiency\08_모든_아나그램.spec.js
 * @Description :
 * @Date        : 2021-07-12 21:30:07
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('08_모든_아나그램', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let a = 'bacaAacba';
    let b = 'abc';
    const result = 3;

    // 테스트 결과 정의
    expect(solution(a, b)).toEqual(result);
  });
});
