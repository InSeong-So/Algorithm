def length(str:str):
    if str == "":
        return 0
    else:
        return 1 + length(str[1:])

# 검증
print(length("test"))