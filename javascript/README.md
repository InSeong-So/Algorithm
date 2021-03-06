# Javscript for Alogrithms : Theory
> 사용 언어 : Javscript

## 조건문(if, else if, else) 사용하여 풀기
인자 값이 정수형태로 정해져 있는 경우 조건문으로 풀 수 있다.

## Math 함수 사용하기
> [MDN](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Math)

### 자주 사용하는 함수

|함수|기능|
|-----------|-----------------|
|Math.abs(x)|숫자의 절댓값 반환|
|Math.cbrt(x)|숫자의 세제곱근을 반환|
|Math.ceil(x)|인수보다 크거나 같은 수 중에서 가장 작은 정수를 반환|
|Math.floor(x)|인수보다 작거나 같은 수 중에서 가장 큰 정수를 반환|
|Math.max([x[, y[, …]]])|0개 이상의 인수에서 제일 큰 수를 반환|
|Math.min([x[, y[, …]]])|0개 이상의 인수에서 제일 작은 수를 반환|
|Math.pow(x, y)|x의 y 제곱을 반환|
|Math.random()|0과 1 사이의 난수를 반환|
|Math.round(x)|숫자에서 가장 가까운 정수를 반환|
|Math.sqrt(x)|숫자의 제곱근을 반환|
|Math.trunc(x)|숫자의 정수 부분을 반환|

## 반복문(for, while) 사용하여 풀기
알고리즘의 시간 복잡도에 가장 큰 영향을 미치며, 어떻게 사용하느냐에 따라 성능이 확연하게 차이가 난다.


## 자바스크립트에서 출력할 수 있는 최대/최솟값
- 최댓값
    ```js
    Number.MAX_SAFE_INTEGER // 9007199254740991
    ```
- 최솟값
    ```js
    Number.MIN_SAFE_INTEGER // -9007199254740991
    ```

## forEach, map, filter, reduce 메서드 사용하기
```js
// 결과값 확인
console.log(array_test());

// 테스트 함수 정의, return 주석 풀고 확인
function array_test(){
  // 배열처리객체 - filter 함수
  // 배열에 조건을 주어 조건에 만족하지 못하는 원소들을 걸러낸다.
  function isTen(value){ return value > 10; }
  var filtered = [11, 3, 9, 130, 44].filter(isTen);
  // return filtered;
  
  // 배열처리객체 - map 함수
  // 어떠한 배열에 특정 규칙을 적용시켜 새로운 배열을 만든다.
  var array = [1.1, 2.1, 3.1, 4.1, 5.1, 6.1, 7.1, 8.1, 9.1, 10.1, 11.1];
  var array10 = array.map(function (elements){ return elements * 10; });
  var arrayMath = array10;
  // return arrayMath;

  // 배열처리객체 - reduce 함수
  // 배열의 값을 한 개로 감소시켜 반환
  var testArray = [];
  for(var i = 1 ; i < 101; i++) { testArray.push(i); }
  var reduceValue = testArray.reduce(function(previousValue, currentValue, currentIndex, array){
    // previousValue : 마지막 콜백에서 반환된 값 또는 initalValue
    // currentValue : 현재 배열 내 처리되고 있는 요소
    // currentIndex : 현재 배열 내 처리되고 있는 요소의 인덱스
    // array : reduce 호출에 사용되는 원 배열
    return previousValue + currentValue;
  });
  // return reduceValue;
}
```

## replace를 replaceAll처럼 사용하기
자바스크립트에는 `replaceAll` 함수가 없다. 이를 정규식을 이용하여 `replace` 함수를 replaceAll 처럼 쓴다.

## 문자열 자르기 : substr, substring
- `substr(시작인덱스, 길이)`
- `substring(시작인덱스, 종료인덱스)`

## 문자열에 문자/단어가 포함되었는지 확인하기
- `indexOf` : 포함하고 있는 문자의 인덱스를 반환한다. `ES6의 `includes`도 동일하다.

## 배열에서 중복제거하기
1. `Set`
2. `filter`

## 주어진 배열에서 순열, 조합, 중복 순열 구하기
유틸함수로 구현해놨으니 파일 참조할 것

## 브루트 포스(완전 탐색)
모든 경우의 수를 전부 탐색하는 것이지만, 쉽게 말하자면 loop로 노가다 뛰는 것이다.

## 소수 구하기
Prime Number를 구하는 알고리즘을 잘 생각해보자.

## array를 뒤집는 reverse()를 이해하자

## 다차원 정렬
```js
array.sort((a, b) => {
  return a[0] - a[0];
})
```

## Parametric Search : 최적 선택지 중에서의 결정
### 조건
1. 최댓값/최솟값을 구하는 형식이며 특정 조건이 만족되는가?
2. `1`이 만족된다면 최댓값을 구할 때는 그보다 작은 값들이, 최솟값을 구할 때는 그보다 큰 값들이 주어진 조건에 만족되어야 한다.
3. 이분탐색의 확장이므로 범위가 정수형이거나 오차 범위가 주어져야 한다.

## Set()을 통한 배열 중복 제거
- `indexOf`는 시간 복잡도가 O(n)이므로 loop문 안에서 사용하면 O(n^2)이다.
  - `Set`을 활용하면 O(nlogn)으로 해결할 수 있다.
```js
// 선언
let set = new Set();
// Set to Array
let array = [...set];
// 또는
array = Array.form(set);
// 또는
set.forEach(v => array.push(v));
// 또는
array = [v for (v of set)];
```

## BFS, DFS 구현하기

# Javscript for Alogrithms : Usage
## jest
```js
// 테스트할 문제명
describe('', () => {
  // 테스트할 케이스명
  it('', () => {
    let a = [1, 3, 9, 5, 2];
    let b = [3, 2, 5, 7, 8];
    expect(solution(a, b)).toEqual([2, 3, 5]);
  });

  // ... 후략
  it('', () => {
    let a = [1, 3, 9, 5, 2];
    let b = [3, 2, 5, 7, 8];
    expect(solution(a, b)).toEqual([2, 3, 5]);
  });
});
```