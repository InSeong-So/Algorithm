def euclid2(m, n):
    if n == 0:
        return m
    else:
        return euclid2(n, m % n)

# 검증
print(euclid2(1920, 486))