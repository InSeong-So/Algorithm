def solution(s):
    answer = []
    
    for char in s:
        if not answer and char == ')':
            return False
        
        if char == ')':
            answer.pop()
        else:
            answer.append(char)

    return not answer

# Stack 개념을 이용하여 풀기
def solution(s):
    c = 0
    for x in s:
        if x == '(':
            c += 1
        else:
            c -= 1
        if c < 0:
            return False
    return True