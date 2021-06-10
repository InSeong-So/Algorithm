def sum(n:int, list):
    if n <= 0:
        return 0
    else:
        return sum(n - 1, list) + list[n-1]

# 검증
print(sum(5, [1,2,3,4,5]))