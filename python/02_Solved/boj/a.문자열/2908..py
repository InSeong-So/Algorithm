N = input().split()

N[0] = ''.join(list(reversed(N[0])))
N[1] = ''.join(list(reversed(N[1])))

print(N[0] if int(N[0]) > int(N[1]) else N[1])