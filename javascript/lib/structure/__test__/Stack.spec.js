import Stack from '../Stack';

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
