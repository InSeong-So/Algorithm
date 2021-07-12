// https://programmers.co.kr/learn/courses/30/lessons/64063

/* Map 객체를 사용하여 해결한다. */

function solution(k, room_number) {
  let check = new Map();

  const answer = room_number.map(number => checkRoom(number));

  function checkRoom(number) {
    if (!check.get(number)) {
      check.set(number, number + 1);
      return number;
    }
    let next = checkRoom(check.get(number));
    check.set(number, next);
    return next;
  }
  return answer;
}

let k = 10;
let room_number = [1, 3, 4, 1, 3, 1];
// result = [1,3,4,2,5,6];
solution(k, room_number);
