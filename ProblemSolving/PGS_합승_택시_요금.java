import java.util.*;

public class PGS_합승_택시_요금 {
	
	class Solution {
	    class Node implements Comparable<Node> {
	        int to, weight;
	        
	        public Node(int to, int weight) {
	            this.to = to;
	            this.weight = weight;
	        }
	        
	        @Override
	        public int compareTo(Node node) {
	            return this.weight - node.weight;   
	        }
	    }
	    
	    ArrayList<Node>[] list;
	    
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = Integer.MAX_VALUE;
	        
	        list = new ArrayList [n + 1];
	        for (int i = 1; i < n + 1; i++) {
	            list[i] = new ArrayList<>();
	        }
	        
	        for (int[] fare : fares) {
	            list[fare[0]].add(new Node(fare[1], fare[2]));
	            list[fare[1]].add(new Node(fare[0], fare[2]));
	        }
	                 
	        int[] minChargeFromS = dijkstra(s);
	        int[] minChargeFromA = dijkstra(a);
	        int[] minChargeFromB = dijkstra(b);
	                 
	        for (int i = 0; i < n + 1; i++) {
	            answer = Math.min(answer, minChargeFromS[i] + minChargeFromA[i] + minChargeFromB[i]);
	        }
	        
	        return answer;
	    }
	                 
	    private int[] dijkstra(int start) {
	        int[] minCharge = new int [list.length];
	        Arrays.fill(minCharge, Integer.MAX_VALUE);
	        minCharge[start] = 0;
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        pq.add(new Node(start, 0));
	        
	        while (!pq.isEmpty()) {
	            Node cur = pq.poll();
	            
	            if (minCharge[cur.to] < cur.weight) {
	                continue;
	            }
	            
	            for (Node next : list[cur.to]) {
	                if (minCharge[next.to] > next.weight + minCharge[cur.to]) {
	                    minCharge[next.to] = next.weight + minCharge[cur.to];
	                    pq.add(new Node(next.to, minCharge[next.to]));
	                }
	            }
	        }
	        
	        return minCharge;
	    }
	}
}
