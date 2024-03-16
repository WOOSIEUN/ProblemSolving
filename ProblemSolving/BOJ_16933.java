import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16933 {
	static class Node {
		int x, y, dist, breakCnt, day;

		public Node(int x, int y, int dist, int breakCnt, int day) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakCnt = breakCnt;
			this.day = day;
		}
	}
	
	static int N, M, K;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (inputStr.charAt(j) == '0' ? true : false);
			}
		}
		
		bw.write(String.valueOf(getMinDist()));
		br.close();
		bw.close();
	}

	private static int getMinDist() {
		boolean[][][][] visited = new boolean [N][M][K + 1][2];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 1, 0, 0));
		visited[0][0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.dist;
			}
			
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				
				if (0 > nx || nx >= N || 0 > ny || ny >= M) {
					continue;
				}
				
				if (map[nx][ny]) {
					if (cur.day == 0 && !visited[nx][ny][cur.breakCnt][cur.day + 1]) {
						queue.add(new Node(nx, ny, cur.dist + 1, cur.breakCnt, cur.day + 1));
						visited[nx][ny][cur.breakCnt][cur.day + 1] = true;
					} else if (cur.day == 1 && !visited[nx][ny][cur.breakCnt][cur.day - 1]) {
						queue.add(new Node(nx, ny, cur.dist + 1, cur.breakCnt, cur.day - 1));
						visited[nx][ny][cur.breakCnt][cur.day - 1] = true;
					}
				} else if (!map[nx][ny] && cur.breakCnt < K) {
					if (cur.day == 0 && !visited[nx][ny][cur.breakCnt + 1][cur.day + 1]) {
						queue.add(new Node(nx, ny, cur.dist + 1, cur.breakCnt + 1, cur.day + 1));
						visited[nx][ny][cur.breakCnt + 1][cur.day + 1] = true;
					} else if (cur.day == 1 && !visited[cur.x][cur.y][cur.breakCnt][cur.day - 1]) {
						queue.add(new Node(cur.x, cur.y, cur.dist + 1, cur.breakCnt, cur.day - 1));
						visited[cur.x][cur.y][cur.breakCnt][cur.day - 1] = true;
					}
				}
			}
		}
		
		return -1;
	}
}