import Queue from '../Queue';

describe('큐 구현 테스트', () => {
  const queue = new Queue();
  queue.enqueue(1);
  queue.enqueue(2);
  queue.enqueue(3);
  queue.enqueue(4);
  queue.enqueue(5);

  it('get', () => {
    expect(queue.get(0)).toEqual(1);
  });
  it('search', () => {
    expect(queue.search(3)).toEqual('2');
  });
  it('dequeue', () => {
    expect(queue.dequeue()).toEqual(1);
  });
  it('empty', () => {
    expect(queue.empty()).toEqual(false);
  });
});
