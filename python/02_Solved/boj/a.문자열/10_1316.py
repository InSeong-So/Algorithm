from collections import deque

N = int(input())
result = 0
for _ in range(N):
    T = input()
    check = []
    result += 1
    for i in T:
        if len(check) == 0:
            check.append(i)
            continue

        if check[len(check) - 1] == i:
            continue
        elif i in check:
            result -= 1
            break
        else:
            check.append(i)

print(result)
