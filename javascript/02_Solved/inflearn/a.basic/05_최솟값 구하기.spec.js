/*=======================================================================================
[ 최솟값 구하기 ]
7개의 수가 주어지면 그 숫자 중 가장 작은 수를 출력하는 프로그램을 작성하라(정렬 사용 금지)
=======================================================================================*/

// ▣ 입력설명
// 첫 번째 줄에 7개의 수가 주어진다.

// ▣ 출력설명
// 첫 번째 줄에 가장 작은 값을 출력한다.

// ▣ 입력예제 1
// 5 3 7 11 2 15 17

// ▣ 출력예제 1
// 2
function solution(arr) {
  // 자바스크립트에서 출력할 수 있는 최댓값
  let min = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < min) min = arr[i];
  }

  return min;
}

// 내장함수 사용1
function solution2(arr) {
  // SpreadOperator 사용하여 arr을 전개한 뒤 인자로 넘긴다.
  return Math.min(...arr);
}

// 내장함수 사용2
function solution3(arr) {
  // apply 함수 사용
  return Math.min.apply(null, arr);
}

let arr = [5, 7, 1, 3, 2, 9, 11];
console.log(solution(arr));
console.log(solution2(arr));
console.log(solution3(arr));
