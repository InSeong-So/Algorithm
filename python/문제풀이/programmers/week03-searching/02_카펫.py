def solution(brown, red):
    answer = []   
    
    # 전체 카펫의 블록 수
    total = brown + red
    # 가로 x 세로 = 총 카펫 블록이므로 전체 카펫의 약수를 구함
    divisors = [i for i in range(1, total+1) if total % i == 0]
    # 빨간 블록의 약수를 구함
    red_divisors = [i for i in range(1, red+1) if red % i == 0]
    red_values = []
    for (y, x) in zip(red_divisors, reversed(red_divisors)):
        if x <= y:
            red_values.append([x, y])
        
    for (y, x) in zip(divisors, reversed(divisors)):
        if y < 3:
            continue
        if y > x:
            break
            
        for item in red_values:
            if item[0] == y - 2 and item[1] == x - 2:
                answer.append(x)
                answer.append(y)
    
    return answer