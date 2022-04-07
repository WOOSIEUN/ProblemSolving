import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
	static class Node {
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, M, R, C, L, nx, ny;
	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int[][][] dirs = { { { 0, 0 } }, { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 } },
			{ { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } },
			{ { -1, 0 }, { 0, -1 } } };
	static int[][] connect = { { 0 }, { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };
	static Node cur;
	static Queue<Node> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			result = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			bfs(R,C,1);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void bfs(int x, int y, int time) {
		queue = new LinkedList<Node>();
		queue.add(new Node(x, y, time));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.time == L)
				return;
			for (int[] dir : dirs[map[cur.x][cur.y]]) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if (isInMap(nx, ny) && !visited[nx][ny] && isConnected(dir[0], dir[1], map[nx][ny])) {
					visited[nx][ny] = true;
					result++;
					queue.offer(new Node(nx, ny, cur.time + 1));
				}
			}
		}
	}

	private static boolean isConnected(int x, int y, int next) {
		int dir = 0;
		if (x == -1)
			dir = 1;
		else if (x == 1)
			dir = 2;
		else if (y == -1)
			dir = 3;
		else if (y == 1)
			dir = 4;
		boolean connected = false;
		for (int available : connect[dir]) {
			if (next == available) {
				connected = true;
				break;
			}
		}
		return connected;
	}

	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M) ? true : false;
	}
}
