def printInBinary(n:int):
    if n < 2:
        print(n, end="")
    else:
        # n을 2로 나눈 몫을 먼저 2진수로 변환하여 인쇄
        printInBinary(n // 2)
        # n을 2로 나눈 나머지를 인쇄
        print(n % 2, end="")

# 검증
printInBinary(5)