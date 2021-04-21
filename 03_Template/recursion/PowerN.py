# n의 x제곱 구하기
def power(n:int, x:int):
    # 종료조건 : n이 0이라면 1을 반환한다.
    if n == 0:
        return 1
    # n이 0보다 크다면 제수 x값에 재귀함수(n - 1, x)을 곱한다.
    else:
        return x * power(n - 1, x)

# 검증
print(power(4, 3))