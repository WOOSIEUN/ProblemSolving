import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_Prim {
	static class Node {
		int vertex, weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int V, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList [V + 1];
		visited = new boolean [V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		bw.write(String.valueOf(prim(1)));
		br.close();
		bw.close();
	}

	private static int prim(int start) {
		int totalWeight = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (!visited[cur.vertex]) {
				visited[cur.vertex] = true;
				totalWeight += cur.weight;
				for (Node next : list[cur.vertex]) {
					if (!visited[next.vertex]) {
						pq.add(next);						
					}
				}
			}				
		}
		return totalWeight;
	}
}
