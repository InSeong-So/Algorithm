from itertools import combinations

def solution(m, weights):
    answer = 0
    
    for l in range(len(weights)):
        for i in combinations(weights, l):
            if sum(i) == m:
                answer += 1
    return answer
    