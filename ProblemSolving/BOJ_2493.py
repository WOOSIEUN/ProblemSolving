import sys
r = sys.stdin.readline

N = int(r())
tower = list(map(int, r().split(" ")))
stack = []
result = []
for i in range(N):
    cur = tower[i]
    while stack:
        if stack[-1][0] < cur:
            stack.pop()
        else:
            result.append(stack[-1][1])
            break
    if not stack:
        result.append(0)
    stack.append([cur, i+1])
print(" ".join(map(str, result)))