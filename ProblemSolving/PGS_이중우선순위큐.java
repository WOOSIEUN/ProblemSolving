import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PGS_이중우선순위큐 {
	
	class Solution {
		public int[] solution(String[] operations) {
	        int[] answer = new int [2];
	        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
	        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((e1, e2) -> (e2 - e1));
	        StringTokenizer st;
	        
	        for (int i = 0; i < operations.length; i++) {
	            st = new StringTokenizer(operations[i]);
	            char cmd = st.nextToken().charAt(0);
	            int num = Integer.parseInt(st.nextToken());
	            
	            if (cmd == 'I') {
	                minQueue.add(num);
	                maxQueue.add(num);
	            } else if (!minQueue.isEmpty()) {
	                if (num == -1){
	                    int deletedNum = minQueue.poll();
	                    maxQueue.remove(deletedNum);
	                } else {                
	                    int deletedNum = maxQueue.poll();
	                    minQueue.remove(deletedNum);
	                }
	            }
	        }
	        
	        if (!minQueue.isEmpty()) {
	            answer[0] = maxQueue.poll();
	            answer[1] = minQueue.poll();
	        }
	        return answer;
	    }
	}
}