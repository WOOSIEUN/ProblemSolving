import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
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
	static int [] dist;
	static boolean [] visited;
	static int V, E, K, start, end, weight;
	static Node cur;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();        
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        
        dist[K] = 0;
        pq.offer(new Node(K, 0));
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
        
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
	}

}
