def solution(seat):
    
    answer = set([])
    
    for item in seat:
        answer.add("-".join([str(_) for _ in item]))
    
    return len(answer)