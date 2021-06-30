/**
 * 순열 구하기
 *
 * @param {*} array
 * @param {*} size
 * @returns
 */
function permutation(array, size) {
  let result = [];

  function permute(t, i) {
    if (t.length === size) {
      result.push(t);
      return;
    }

    if (i + 1 > array.length) {
      return;
    }

    permute(t.concat(array[i]), i + 1);
    permute(t, i + 1);
  }
  // 재귀 시작
  permute([], 0);
  return result;
}

/**
 * 중복 순열 구하기
 *
 * @param {*} array
 * @param {*} size
 * @returns
 */
function repetitionPermutation(array, size) {
  let result = [];

  function repetitionPermute(t, sz) {
    if (t.length === sz) {
      result.push(t);
      return;
    }
    for (let i = 0; i < array.length; i++) {
      repetitionPermute(t.concat([array[i]]), sz);
    }
  }

  repetitionPermute([], size);

  return result;
}

/**
 * 조합 구하기
 *
 * @param {*} array
 * @returns
 */
function combination(array) {
  let result = [];
  let combination = [];
  let slent = Math.pow(2, array.length);

  for (let i = 0; i < slent; i++) {
    combination = [];
    for (let j = 0; j < array.length; j++) {
      if (i & Math.pow(2, j)) {
        combination.push(array[j]);
      }
    }
    if (combination.length > 0) {
      result.push(combination);
    }
  }

  return result;
}

const array = permutation([1, 2, 3, 4], 3).map(a => {
  return a.join('');
});

const array2 = combination([1, 2, 3, 4]);
const array3 = repetitionPermutation([1, 2, 3, 4], 4);

// console.log(Math.max(...array));
// console.log(array2);
console.log(array3);
