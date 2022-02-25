import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22865 {
	static class Node implements Comparable<Node> {
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static ArrayList<Node> [] list;
	static int [] distA, distB, distC;
	static boolean [] visited;
	static int N, A, B, C, M, start, end, weight, min, max, maxIdx;
	static Node cur;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        distA = new int[N + 1];
        distB = new int[N + 1];
        distC = new int[N + 1];
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        Arrays.fill(distC, Integer.MAX_VALUE);
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>(); 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		Dijkstra(A, distA);
		Dijkstra(B, distB);
		Dijkstra(C, distC);
        
        for(int i = 1; i <= N; i++){
        	min = Math.min(distA[i], Math.min(distB[i], distC[i]));
        	if(max < min) {
        		max = min;
        		maxIdx = i;
        	}
        }
        bw.write(""+maxIdx);
        bw.close();
        br.close();
	}
	
	static void Dijkstra (int start, int[] dist) {
        visited = new boolean[N + 1];
		dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            cur = pq.poll();

            if(visited[cur.to] == true) continue;
            visited[cur.to] = true;

            for(Node node : list[cur.to]){
                if(dist[node.to] > dist[cur.to] + node.weight){
                    dist[node.to] = dist[cur.to] + node.weight;
                    pq.add(new Node(node.to, dist[node.to]));
                }
            }
        } 
	}
}
