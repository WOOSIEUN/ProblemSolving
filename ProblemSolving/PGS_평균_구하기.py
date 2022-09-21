def solution(arr):
    answer = 0
    for item in arr :
        answer += item
    return answer / len(arr)