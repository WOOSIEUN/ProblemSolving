import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
	static class Node implements Comparable<Node> {
		int idx, time;
		
		 public Node(int idx, int time) {
			 this.idx = idx;
			 this.time = time;
		 }

		@Override
		public int compareTo(Node node) {
			return this.time - node.time;
		}
	}
	
	static final int MAX = 100001;
	static int N, K;
	static boolean[] visited = new boolean [MAX];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(hideAndSeek()));
		br.close();
		bw.close();
	}

	private static int hideAndSeek() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(N, 0));
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			visited[cur.idx] = true;
			
			if (cur.idx == K) {
				return cur.time;
			}
			
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = cur.idx - 1;
				} else if (i == 1) {
					next = cur.idx + 1;
				} else {
					next = cur.idx * 2;
				}
				
				if (isInMap(next) && !visited[next]) {					
					if (i == 0 || i == 1) {
						queue.add(new Node(next, cur.time + 1));
					} else {
						queue.add(new Node(next, cur.time));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isInMap(int target) {
		return 0 <= target && target < MAX;
	}
}
