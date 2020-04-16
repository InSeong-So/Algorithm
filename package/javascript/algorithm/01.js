function solution(participant, completion) {
    var answer = '';

    var map1 = new Map();
    participant.forEach(function (item) {
        if (!map1.get(item)) {
            map1.set(item, 1);
        } else {
            map1.set(item, map1.get(item) + 1);
        }
    });

    completion.forEach(function (item) {
        if (map1.has(item)) {
            map1.set(item, Number(map1.get(item)) - 1);
        }
    });

    for (let [key, value] of map1) {
        if (value == 1) {
            answer = key;
        }
    }

    return answer;
}

var test1 = ["marina", "josipa", "nikola", "vinko", "filipa", "josipa"];
var test2 = ["marina", "josipa", "nikola", "vinko", "filipa"];

console.log(solution(test1, test2));