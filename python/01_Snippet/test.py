# 부분 집합을 구할 원소 배열
data = ['a', 'b', 'c', 'd', 'e', 'f']
# 주어진 원소 배열의 길이
N = len(data)
# 
include = [False] * N

# data[k]...data[N-1]의 멱집합을 구한 뒤 include 배열의 true인 원소를 출력
def powerSet(K:int):
    if K == N:
        for i in range(N):
            if include[i]:
                print(data[i], end=" ")
        print("")
        return
    # data[k], 즉 집합 S의 첫 번째 원소를 포함하지 않는 경우
    include[K] = False
    powerSet(K + 1)
    # data[k], 즉 집합 S의 첫 번째 원소를 포함하는 경우
    include[K] = True
    powerSet(K + 1)

# 처음 함수를 호출할 때 0으로 호출한다. P는 공집합, S는 전체 집합이다.
powerSet(0)