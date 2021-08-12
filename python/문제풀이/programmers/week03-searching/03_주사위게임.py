from itertools import product


def solution(monster, S1, S2, S3):
    p = product(range(S1), range(S2), range(S3))
    case = len([x for x in p if sum(x) + 4 not in monster])
    return int(case / (S1 * S2 * S3) * 1000)
