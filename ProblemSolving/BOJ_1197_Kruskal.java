import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_Kruskal {
	static class Node {
		int from, to, weight;
		
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static PriorityQueue<Node> pq;
	static int[] parent;
	static int V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int [V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i;
		}
		
		pq = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Node(from, to, weight));
		}
		
		bw.write(String.valueOf(kruskal()));
		br.close();
		bw.close();
	}

	private static int kruskal() {
		int totalWeight = 0;	
		for(int i = 0; i < E; i++) {
			Node cur = pq.poll();
			if(find(cur.to) != find(cur.from)) {
				totalWeight += cur.weight;
				union(cur.to, cur.from);
			}
		}
		return totalWeight;
	}
	
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}
