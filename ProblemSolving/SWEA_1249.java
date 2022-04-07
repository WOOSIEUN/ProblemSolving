import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249 {
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, result, nx, ny;
	static String line;
	static boolean[][] visited;
	static int[][] map, dist, dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static Node cur;
	static Queue<Node> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = line.charAt(j) - '0';
			}
			findMinDist();
			sb.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static void findMinDist() {
		queue = new LinkedList<Node>();
		queue.add(new Node(0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny))
					if (!visited[nx][ny] || dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
						visited[nx][ny] = true;
						dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
						queue.offer(new Node(nx, ny));
					}
			}
		}
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N) ? true : false;
	}
}
