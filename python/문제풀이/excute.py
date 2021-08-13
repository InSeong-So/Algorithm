def solution(str):
    result = 0
    answer = 1
    for i in range(1, len(str)):
        if str[i - 1] == str[i]:
            answer += 1
            if i == len(str) - 1:
                result = max(result, answer)
        else:
            result = max(result, answer)
            answer = 1
    print(result)


for _ in range(3):
    solution(input())
