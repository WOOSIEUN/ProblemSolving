import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, nx, ny, result;
	static int[][] map, copy, dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Node cur;
	static Queue<Node> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0);		
		bw.write("" + result);
		br.close();
		bw.close();
	}

	private static void dfs(int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0;
				}
	}

	private static void bfs() {
		queue = new LinkedList<Node>();
		copyAndFind(map, copy);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny) && copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					queue.offer(new Node(nx, ny));
				}
			}
		}
		getSafeArea(copy);
	}

	private static void getSafeArea(int[][] virus) {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if(virus[i][j] == 0) cnt++;
			}		
		result = Math.max(result, cnt);
	}

	private static void copyAndFind(int[][] src, int[][] des) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				des[i][j] = src[i][j];
				if(des[i][j] == 2) queue.add(new Node(i, j));
			}
	}

	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < M) ? true : false;
	}
}
