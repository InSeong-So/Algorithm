def euclid2(m:int, n:int):
    if n == 0:
        return m
    else:
        return euclid2(n, m % n)

# 검증
print(euclid2(180, 8))