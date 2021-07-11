function solution(gems) {
  var count = new Set(gems).size;
  // // 보석 종류가 몇개인지
  var gemMap = new Map();
  gemMap.delete('DIA');
  // // 보석 종류 => 보석 자리를 저장하기 위한 맵
  var gemLength = [];
  // // 보석을 모두 포함하는 구간을 저장할 배열
  gems.forEach((gem, i) => {
    gemMap.delete(gem);
    gemMap.set(gem, i);
    if (gemMap.size === count) {
      gemLength.push([gemMap.values().next().value + 1, i + 1]);
    }
  });

  gemLength.sort((a, b) => {
    if (a[1] - a[0] === b[1] - b[0]) {
      return a[1] - b[1];
    }
    return a[1] - a[0] - (b[1] - b[0]);
  });

  // return gemLength[0];
}

let arr1 = ['DIA', 'RUBY', 'RUBY', 'DIA', 'DIA', 'EMERALD', 'SAPPHIRE', 'DIA'];
let result1 = [3, 7];
let arr2 = ['AA', 'AB', 'AC', 'AA', 'AC'];
let result2 = [1, 3];
let arr3 = ['XYZ', 'XYZ', 'XYZ'];
let result3 = [1, 1];
let arr4 = ['ZZZ', 'YYY', 'NNNN', 'YYY', 'BBB'];
let result4 = [1, 5];

solution(arr1);
