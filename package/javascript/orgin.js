/** JavaScript Array로 자료구조의 알고리즘 적용
 * 
 * 내장 함수 1차(push, pop, shift, unshift, indexOf, splice, slice)
 * 내장 함수 2차(map, filter, find, keys, concat, flat, entries, includes)
 */

const fruits = ["영어", "과학", "사회/생활", "국어", "수학", "체육"];

fruits.push("한문");
console.log(fruits.pop());
console.log(fruits);
console.log(fruits.shift());
console.log(fruits);
console.log(fruits.unshift("과학"));
console.log(fruits);
console.log(fruits.indexOf("국어"));
console.log(fruits.shift());
console.log(fruits.splice(0, 1));
console.log(fruits);
const FruitsCopy = fruits.slice();
console.log(fruits);
console.log(FruitsCopy);

/** 배열 처리 객체
 * 
 * map, reduce, filter
 */

// 결과값 확인
console.log(array_test());

// 테스트 함수 정의, return 주석 풀고 확인
function array_test() {
    // 배열처리객체 - filter 함수
    // 배열에 조건을 주어 조건에 만족하지 못하는 원소들을 걸러낸다.
    function isTen(value) { return value > 10; }
    var filtered = [11, 3, 9, 130, 44].filter(isTen);
    // return filtered;

    // 배열처리객체 - map 함수
    // 어떠한 배열에 특정 규칙을 적용시켜 새로운 배열을 만든다.
    var array = [1.1, 2.1, 3.1, 4.1, 5.1, 6.1, 7.1, 8.1, 9.1, 10.1, 11.1];
    var array10 = array.map(function(elements) { return elements * 10; });
    var arrayMath = array10;
    // return arrayMath;

    // 배열처리객체 - reduce 함수
    // 배열의 값을 한 개로 감소시켜 반환
    var testArray = [];
    for (var i = 1; i < 101; i++) { testArray.push(i); }
    var reduceValue = testArray.reduce(function(previousValue, currentValue, currentIndex, array) {
        // previousValue : 마지막 콜백에서 반환된 값 또는 initalValue
        // currentValue : 현재 배열 내 처리되고 있는 요소
        // currentIndex : 현재 배열 내 처리되고 있는 요소의 인덱스
        // array : reduce 호출에 사용되는 원 배열
        return previousValue + currentValue;
    });
    // return reduceValue;
}