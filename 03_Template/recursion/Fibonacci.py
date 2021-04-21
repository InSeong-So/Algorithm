# 피보나치 수 구하기
def fibonacci(n:int):
    # 종료조건 : n - 2가 0보다 작아질 경우 2를 반환한다.
    if n < 2:
        return n
    # n - 2가 0보다 크다면 각각 재귀함수를 호출하여 더한다.
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

# 검증
print(fibonacci(4))