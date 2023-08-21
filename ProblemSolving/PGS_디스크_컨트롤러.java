import java.util.PriorityQueue;

public class PGS_디스크_컨트롤러 {
	
	class Solution {
		class Task {
	        int request, duration;        
	        public Task(int request, int duration) {
	            this.request = request;
	            this.duration = duration;
	        }
	    }
	    
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        PriorityQueue<Task> tasks = new PriorityQueue<>((task1, task2) -> (task1.request - task2.request));
	        PriorityQueue<Task> readyQueue = new PriorityQueue<>((task1, task2) -> (task1.duration - task2.duration));
	        for (int[] job : jobs) {
	            tasks.add(new Task(job[0], job[1]));
	        }
	        
	        int count = 0, curTime = 0, totalDuration = 0;
	        while (count < jobs.length) {            
	            while (!tasks.isEmpty() && curTime >= tasks.peek().request) {
	                readyQueue.add(tasks.poll());
	            }
	            
	            if (readyQueue.isEmpty()) {
	                curTime = tasks.peek().request;
	            } else {
	                Task curTask = readyQueue.poll();
	                curTime += curTask.duration;
	                totalDuration += (curTime - curTask.request);
	                count++;
	            }             
	            
	        }
	        return totalDuration / jobs.length;
	    }
	}
}