import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	static class Node {
		int x, y, k, cnt;
		public Node(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}

	static int[][] monkeyDirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] horseDirs = { { -1, -2 },{ -2, -1 },{ -2, 1 },{ -1, 2 },{ 2, 1 },{ 1, 2 },{ 2, -1 },{ 1, -2 } };
	static Queue<Node> queue = new LinkedList<Node>();
	static int K, W, H, nx, ny, result;
	static int [][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		result = bfs(0, 0);
		bw.write("" + result);
		br.close();
		bw.close();
	}

	private static int bfs(int x, int y) {
		queue.offer(new Node(x, y, K, 0)); 
		visited[x][y][K] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if(cur.x == H - 1 && cur.y == W - 1) return cur.cnt;
			for (int[] dir : monkeyDirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][cur.k]) {
					visited[nx][ny][cur.k] = true;
					queue.offer(new Node(nx, ny, cur.k, cur.cnt + 1));
				}
			}
			if (cur.k > 0) {
				for (int[] dir : horseDirs) {
					nx = cur.x + dir[0];
					ny = cur.y + dir[1];
					if(isInMap(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny][cur.k - 1]) {
						visited[nx][ny][cur.k - 1] = true;
						queue.offer(new Node(nx, ny, cur.k - 1, cur.cnt + 1));
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < H && 0 <= y && y < W) ? true : false;
	}
}
