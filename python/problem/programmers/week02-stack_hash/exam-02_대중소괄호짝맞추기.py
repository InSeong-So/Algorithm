from collections import deque

def solution(s):
    
    arr = []
    
    for char in s:
        try:
            if char == ')' and arr[-1] == '(':
                arr.pop()
                continue
            elif char == '}' and arr[-1] == '{':
                arr.pop()
                continue
            elif char == ']' and arr[-1] == '[':
                arr.pop()
                continue
            arr.append(char)
        except:
            return False
    
    return not arr