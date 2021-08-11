/*=======================================================================================
[아나그램(해쉬)]
두 문자열이 알파벳의 나열 순서는 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 한다. 
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 
A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치한다.
즉 어느 한 단어를 재배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 한다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하라.
아나그램 판별시 대소문자가 구분된다.
*/

// ▣ 입력설명
// 첫 번째 단어와 두 번째 단어가 입력된다.
// 단어의 길이는 100을 넘지 않는다.

// ▣ 출력설명
// 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력한다.

// ▣ 입력예제 1
// AbaAeCe
// baeeACA

// ▣ 출력예제 1
// YES

// ▣ 입력예제 2
// abaCC
// Caaab

// ▣ 출력예제 2
// NO

/* 집합 자료구조로 해결하기 */
function solution(str1, str2) {
  let answer = 'YES';

  let strings = new Map();

  for (let s of str1) {
    if (strings.has(s)) {
      strings.set(s, strings.get(s) + 1);
    } else {
      strings.set(s, 1);
    }
  }

  for (let s of str2) {
    if (!strings.has(s) || strings.get(s) === 0) {
      return 'NO';
    } else {
      strings.set(s, strings.get(s) - 1);
    }
  }

  return answer;
}

/**
 * ========================================================
 * @Title       : 07_아나그램
 * @Path        : javascript\02_Solved\inflearn\e.efficiency\07_아나그램.spec.js
 * @Description :
 * @Date        : 2021-07-12 21:28:06
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('07_아나그램', () => {
  // 테스트 케이스명
  it('기본1', () => {
    // 파라미터 정의
    let a = 'AbaAeCe';
    let b = 'baeeACA';
    const result = 'YES';

    // 테스트 결과 정의
    expect(solution(a, b)).toEqual(result);
  });

  // 테스트 케이스명
  it('기본2', () => {
    // 파라미터 정의
    let a = 'abaCC';
    let b = 'Caaab';
    const result = 'NO';

    // 테스트 결과 정의
    expect(solution(a, b)).toEqual(result);
  });
});
