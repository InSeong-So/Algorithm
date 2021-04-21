def printStringReverse(str:str):
    if len(str) == 0:
        return
    else:
        printStringReverse(str[1:])
        print(str[:1], end="")

# 검증
printStringReverse("test")