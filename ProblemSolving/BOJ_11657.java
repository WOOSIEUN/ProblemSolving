import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
	static class Node implements Comparable<Node> {
		int from, to, weight;
		
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static Node [] list;
	static long [] dist;
	static boolean [] visited;
	static int N, M, start, end, weight, min;
	static boolean isMinusCycle;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        list = new Node [M];
        dist = new long [N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list[i] = new Node(start, end, weight);
		}
		
		dist[1] = 0;
		for (int i = 0; i < N + 1; i++) {
			for (Node cur : list) {
				if(dist[cur.from] == Integer.MAX_VALUE) continue;
				if(dist[cur.to] > dist[cur.from] + cur.weight) {
					dist[cur.to] = dist[cur.from] + cur.weight;
					if(i == N) isMinusCycle = true;
				}
			}
		}
		if(isMinusCycle) sb.append("-1");
		else {
			for (int i = 2; i < N + 1; i++) {
				if(dist[i] == Integer.MAX_VALUE) sb.append("-1\n");
				else sb.append(dist[i]).append("\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
