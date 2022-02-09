import heapq
import sys

r = sys.stdin.readline
heap = []
N = int(r())
for _ in range(N):
    tmp = list(map(int, r().split()))
    if not heap:
        for e in tmp:
            heapq.heappush(heap, e)
    else:
        for e in tmp:
            if heap[0] < e:
                heapq.heappop(heap)
                heapq.heappush(heap, e)
print(heap[0])
