import java.util.*;

public class PGS_야근_지수 {
	
	class Solution {

		public long solution(int n, int[] works) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			for (int work : works) {
				pq.add(work);
			}

			for (int i = 0; i < n; i++) {
				int work = pq.poll();
				if (work == 0) {
					break;
				}

				pq.offer(work - 1);
			}

			long answer = 0;
			while (!pq.isEmpty()) {
				int work = pq.poll();
				answer += work * work;
			}
			return answer;
		}
	}
	
}
