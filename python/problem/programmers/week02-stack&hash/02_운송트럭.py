def solution(max_weight, specs, names):
    answer = 1
    specs = dict(specs)
    sum_weight = 0

    for name in names:
        weight = int(specs[name])
        sum_weight += weight
        if sum_weight > max_weight:
            sum_weight = weight
            answer += 1

    return answer
