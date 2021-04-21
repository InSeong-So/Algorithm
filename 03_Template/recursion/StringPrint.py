def printString(str:str):
    if len(str) == 0:
        return
    else:
        print(str[:1], end="")  # 아래와 비교 1
        printString(str[1:]) # 아래와 비교 2

# 검증
printString("test")