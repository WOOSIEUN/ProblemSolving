import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
	static class Node implements Comparable<Node>{
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ArrayList<Node>[] graph = new ArrayList [n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to, weight));
			}
			
			int[] dist = dijkstra(c, graph);
			
			int cnt = 0, maxDist = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					continue;
				}
				maxDist = Math.max(dist[i], maxDist);
				cnt++;
			}
			
			sb.append(cnt).append(" ").append(maxDist).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int[] dijkstra(int start, ArrayList<Node>[] graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int [graph.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.to] < cur.weight) {
				continue;
			}
			
			for (Node next : graph[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.weight) {
					dist[next.to] = dist[cur.to] + next.weight;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist;
	}
}
