import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251 {
	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}		
		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}
	
	static int N, from, to, cnt;
	static double E, result;
	static int[] parents;
	static PriorityQueue<Edge> edgeQueue;
	static Edge cur;
	static int [] X;
	static int [] Y;
	
	public static void makeSet() {
		parents = new int[N];
		for(int i = 0; i < N; i++)
			parents[i] = i;		
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union (int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			makeSet();
			edgeQueue = new PriorityQueue<Edge>();
			result = cnt = 0;
			X = new int[N];
            Y = new int[N];
            
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)	X[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)	Y[i] = Integer.parseInt(st.nextToken());
			E = Double.parseDouble(br.readLine());
			
			for (int from = 0; from < N; from++)
				for (int to = 0; to < N; to++)
					edgeQueue.offer(new Edge(from, to, getWeight(X[from], X[to], Y[from], Y[to])));
						
			while (!edgeQueue.isEmpty()) {
				cur = edgeQueue.poll();
				if(union(cur.from, cur.to)) {
					result += cur.weight;
					if(++cnt == N - 1) break;
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(result * E)).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static double getWeight(long fromX, long toX, long fromY, long toY) {
		return Math.pow(fromX - toX, 2) + Math.pow(fromY - toY, 2);
	}
}
