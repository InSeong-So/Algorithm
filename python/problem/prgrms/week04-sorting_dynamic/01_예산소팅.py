def solution(d, budget):

    answer = 0
    price_sum = 0

    for price in sorted(d):
        price_sum += price
        if price_sum > budget: # 예산을 초과하면
            break
        answer += 1

    return answer