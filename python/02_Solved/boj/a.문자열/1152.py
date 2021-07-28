N = input().split()

def reverse_string(str):
  return ''.join(reversed(str))

A = reverse_string(N[0])
B = reverse_string(N[1])

print(max([int(A), int(B)]))