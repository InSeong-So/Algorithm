export default class Queue {
  constructor() {
    this._arr = [];
  }

  // Overflow : 큐가 가득 차서 더 이상 자료를 넣을 수 없는 경우로서 put이 불가능
  // Underflow : 큐가 비어 있어 자료를 꺼낼 수 없는 경우로 get이 불가능

  // put(insert) : 큐에 자료를 넣는다.
  enqueue(item) {
    this._arr.push(item);
  }
  // get(delete) : 큐에서 자료를 꺼낸다.
  dequeue() {
    if (this._arr.length === 0) {
      return -1;
    }
    return this._arr.shift();
  }
  get(index) {
    if (this._arr.length === 0) {
      return -1;
    }
    return this._arr[index];
  }
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
    if (!result) {
      return -1;
    }

    return result;
  }
  // front(head) : 데이터를 get할 수 있는 위치
  front() {
    return this._arr[0];
  }
  // rear(tail) : 데이터를 put할 수 있는 위치
  rear() {
    return this._arr[this._arr.length - 1];
  }

  // 큐에 있는 요소의 갯수 반환
  size() {
    return this._arr.length;
  }

  // 큐 비우기
  clear() {
    this._arr = [];
  }

  // 큐이 비어있는지 여부를 반환
  empty() {
    return this._arr.length > 0 ? false : true;
  }
}
