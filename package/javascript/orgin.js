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