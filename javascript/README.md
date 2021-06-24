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