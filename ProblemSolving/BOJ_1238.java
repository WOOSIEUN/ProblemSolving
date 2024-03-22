import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
	static class Node implements Comparable<Node> {
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
	
	static final int MAX = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		ArrayList<ArrayList<Node>> reversedGraph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			reversedGraph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, weight));
			reversedGraph.get(to).add(new Node(from, weight));
		}
		
		int[] minDistToHome = getMinDist(X, graph);
		int[] minDistToTown = getMinDist(X, reversedGraph);
		
		int maxTime = 0;
		for (int i = 0; i < N; i++) {
			maxTime = Math.max(maxTime, minDistToHome[i] + minDistToTown[i]);
		}
		
		bw.write(String.valueOf(maxTime));
		br.close();
		bw.close();
	}

	private static int[] getMinDist(int x, ArrayList<ArrayList<Node>> graph) {
		int[] minDist = new int [graph.size()];
		Arrays.fill(minDist, MAX);		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x, 0));
		minDist[x] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (minDist[cur.to] < cur.weight) {
				continue;
			}
			
			for (Node next : graph.get(cur.to)) {
				if (minDist[next.to] > minDist[cur.to] + next.weight) {
					minDist[next.to] = minDist[cur.to] + next.weight;
					pq.add(new Node(next.to, minDist[next.to]));
				}
			}
		}
		
		return minDist;
	}
}
