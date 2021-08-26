const SIS = {
  /**
   * 숫자 + 문자 + 특수문자가 섞인 문자 정렬
   *
   * @param {*} arr
   * @returns sorted Array
   */
  sorted: function (arr) {
    /**
     * let arr = [
     *   ['DS7651', 'A0'],
     *   ['CA0055', 'D+'],
     *   ['AI5543', 'C0'],
     *   ['OS1808', 'B-'],
     *   ['DS7651', 'B+'],
     *   ['AI0001', 'F'],
     *   ['DB0001', 'B-'],
     *   ['AI5543', 'D+'],
     *   ['DS7651', 'A+'],
     *   ['OS1808', 'B-'],
     * ];
     */
    const _arr = Array.from(arr);
    return _arr.sort((a, b) => {
      const order = { '+': -1, '-': 1, 0: 0, undefined: 0 };
      // return a[0].localeCompare(b[0], undefined, { numeric: true, sensitivity: 'base' })
      return a[0].localeCompare(b[0]) || order[a[1]] - order[b[1]];
    });
  },
  /**
   * 문자열을 배열로 반환
   *
   * @param {*} str
   * @returns
   */
  stringToArray: function (str) {
    return str.split('');
  },
  /**
   * map 객체를 2차원 배열로 변환
   *
   * @param {*} map
   * @returns
   */
  mapTo2DArray: function (map) {
    /*
     * Map { 'a' => 1, 'b' => 2 }
     */
    return Array.from(map, ([name, value]) => [name, value]);
  },
  /**
   * 1차원 배열을 인덱스를 키로 하는 map 객체로 변환
   *
   * @param {*} arr
   * @returns
   */
  arrayToMapFromIndexKey: function (arr) {
    // // 1. Object.assign()
    // Object.assign({}, ['a','b','c']); // {0:"a", 1:"b", 2:"c"}
    // // 2. spread operator
    // { ...['a', 'b', 'c'] } // {0:"a", 1:"b", 2:"c"}
    return arr.reduce((obj, cur, i) => ((obj[i] = cur), obj), {});
  },
};

// 사용
SIS.arrayToMap([1, 0, 0, 1]);
