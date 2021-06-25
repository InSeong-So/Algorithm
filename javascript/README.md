# Javscript for Alogrithms
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