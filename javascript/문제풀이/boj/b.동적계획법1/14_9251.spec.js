/**
 * 입력
 */
var line = require('fs').readFileSync('/dev/stdin', 'utf8');

const [str1, str2] = line.trim().split('\n');

const string_1 = str1.split('');
const string_2 = str2.split('');
string_1.unshift('_');
string_2.unshift('_');

const dp_pre = new Array(string_2.length + 1).fill(0);
const dp_current = new Array(string_2.length + 1).fill(0);

let rstVal = 0;

for (var i = 1; i <= str1.length; i++) {
  //초기화
  dp_current.forEach((v, i) => {
    dp_pre[i] = v;
    dp_current[i] = 0;
  });

  for (var j = 1; j <= str2.length; j++) {
    if (string_1[i] === string_2[j]) {
      dp_current[j] = dp_pre[j - 1] + 1;
      rstVal = Math.max(rstVal, dp_current[j]);
    } else {
      dp_current[j] = Math.max(dp_current[j - 1], dp_pre[j]);
    }
  }
}

console.log(rstVal);

/**
 * ========================================================
 * @Title       : 14_9251
 * @Path        : javascript\문제풀이\boj\b.동적계획법1\14_9251.spec.js
 * @Link        : https://www.acmicpc.net/problem/14_9251
 * @Description :
 * @Note        : 1. I/O 신경 쓰지 말고 solution() 함수만 잘 작성하자
 *              :
 * @Date        : 2021-09-02 21:46:51
 * --------------------------------------------------------
 * @Author      : Inseong-so(https://github.com/inseong-so)
 * ========================================================
 */
describe('14_9251', () => {
  // 테스트 케이스명
  it('기본1', () => {
    console.log = jest.fn();
    // 변수 입력하기
    const input = '';
    // 함수 실행
    solution(input);
    // 결과
    const result = 0;

    // 테스트 결과 정의
    expect(console.log).toHaveBeenCalledWith(result);
  });
});
