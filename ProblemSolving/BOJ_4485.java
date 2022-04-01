import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
	static class Node implements Comparable<Node> {
		int x, y, w;
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static int N, cnt, nx, ny;	
	static int [][] map, dist, dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int [N][N];
			dist = new int [N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			pq = new PriorityQueue<Node>();
			sb.append("Problem ").append(++cnt).append(": ").append(dijkstra()).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int dijkstra() {
		dist[0][0] = map[0][0];
		pq.offer(new Node(0, 0, dist[0][0]));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny) && dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, dist[nx][ny]));
				}
			}
		}
		return dist[N-1][N-1];
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N) ? true : false;
	}
}