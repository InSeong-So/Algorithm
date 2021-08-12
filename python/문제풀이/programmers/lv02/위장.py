# 의상종류가 3개면 각각의 부위에서 안 입는 것, 첫번째, 두번째, 세번째 총 4개의 선택이 가능
# 부위별로 가능한 선택 수를 곱하면 모든 조합이 나오는데 최소 하나는 입어야 해서 1을 빼야 한다.

def solution(clothes):
    answer = 1

    d = dict()

    for c, j in clothes:
        if d.get(j):
            d[j] += 1
        else:
            d[j] = 1

    for i in d.keys():
        answer *= (d[i] + 1)

    return answer - 1
