from collections import Counter

def solution(v):
    answer = []
    
    x = []
    y = []
    
    for item in v:
        x.append(item[0])
        y.append(item[1])
            
    c = Counter(x)
    d = Counter(y)
    for k, v in c.items():
        if v == 1:
            answer.append(k)
    for k, v in d.items():
        if v == 1:
            answer.append(k)
        
    return answer