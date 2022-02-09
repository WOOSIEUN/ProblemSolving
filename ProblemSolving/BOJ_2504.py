import sys

r = sys.stdin.readline
lst = list(r())
stack = []
result = 0
tmp = 1
for i in range(len(lst)):
    if lst[i] == "(":
        tmp *= 2
        stack.append(lst[i])
    elif lst[i] == "[":
        tmp *= 3
        stack.append(lst[i])
    elif lst[i] == ")":
        if not stack or stack[-1] != "(":
            result = 0
            break
        elif lst[i - 1] == "(":
            result += tmp
        tmp //= 2
        stack.pop()
    elif lst[i] == "]":
        if not stack or stack[-1] != "[":
            result = 0
            break
        elif lst[i - 1] == "[":
            result += tmp
        tmp //= 3
        stack.pop()
if stack:
    result = 0
print(result)
