# 1 ~ n까지의 곱 구하기
def factorial(n:int):
    # 종료조건 : n이 0이라면 1을 반환한다.
    if n == 0:
        return 1
    # n이 0보다 크다면 현재의 n값에 재귀함수(n - 1)을 곱한다.
    else:
        return n * factorial(n - 1)
        
# 검증
print(factorial(4))