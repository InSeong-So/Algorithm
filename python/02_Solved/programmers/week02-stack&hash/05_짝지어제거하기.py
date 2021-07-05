def solution(s):
    answer = 0

    arr = []
    for char in s:
        if arr and arr[-1] == char:
            arr.pop()
        else:
            arr.append(char)
            
    if not arr:
        answer = 1

    return answer