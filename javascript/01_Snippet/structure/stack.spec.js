class Stack {
  constructor() {
    this._arr = [];
  }

  // 스택 맨 위에 요소 추가
  push(item) {
    this._arr.push(item);
  }

  // 스택의 맨 위 요소를 제거하고 반환
  pop() {
    if (this._arr.length === 0) {
      return -1;
    }
    return this._arr.pop();
  }

  // 스택의 맨 위 요소를 반환
  peek() {
    return this.arr[this._arr.length - 1];
  }

  get(index) {
    if (this._arr.length === 0) {
      return -1;
    }
    return this._arr[index];
  }

  // 스택에서 특정 값의 위치 찾기
  search(value) {
    let result = [];

    if (this._arr.length === 0) {
      return -1;
    }

    for (let i = 0; i < this._arr.length; i++) {
      if (value === this._arr[i]) {
        result.push(i);
      }
    }

    result = result.join(' ');
    // 없다면 -1 반환
    if (!result) {
      return -1;
    }
    return result;
  }

  // 스택에 있는 요소의 갯수 반환
  size() {
    return this._arr.length;
  }

  // 스택 비우기
  clear() {
    this._arr = [];
  }

  // 스택이 비어있는지 여부를 반환
  empty() {
    return this._arr.length > 0 ? false : true;
  }
}

// console.log();

describe('스택 구현 테스트', () => {
  const stack = new Stack();

  // it('error:get', () => {
  //   expect(stack.get(0)).toEqual(-1);
  // });

  stack.push(1);
  stack.push(2);
  stack.push(3);
  stack.push(5);
  stack.push(4);
  stack.pop();
  stack.push(5);

  it('get', () => {
    expect(stack.get(0)).toEqual(1);
  });
  it('search', () => {
    expect(stack.search(5)).toEqual('3 4');
  });
  it('empty', () => {
    expect(stack.empty()).toEqual(false);
  });
});
