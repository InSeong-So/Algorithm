import string

N = input().upper()

arr = [0 for _ in range(len(string.ascii_uppercase))]

for i in N:
  arr[int(ord(i)) - 65] += 1

max = 0
index = 0
for i in range(len(arr)):
  if max < arr[i]:
    max = arr[i]
    index = i

for i in range(len(arr)):
  if index == i:
    continue

  if max == arr[i]:
    index = '?'
    break


if index == '?':
  print('?')
else:
  print(chr(index + 65))