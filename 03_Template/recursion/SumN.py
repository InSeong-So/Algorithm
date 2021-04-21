# 0 ~ n 까지의 합을 구하기
def recursionSum(n:int):
    # 종료조건 : n이 0이라면 0을 반환한다.
    if n == 0:
        return 0
    # n이 0보다 크다면 현재의 n값에 재귀함수(n - 1)을 더한다.
    else:
        return n + recursionSum(n - 1)

# 검증
print(recursionSum(4))