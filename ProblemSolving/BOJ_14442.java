import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442 {
	static class Node {
		int x, y, dist, breakCnt;

		public Node(int x, int y, int dist, int breakCnt) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.breakCnt = breakCnt;
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
		boolean[][][] visited = new boolean [N][M][K + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.dist;
			}
			
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				
				if (!isInMap(nx, ny)) {
					continue;
				}
				
				if (!visited[nx][ny][cur.breakCnt] && map[nx][ny]) {
					queue.add(new Node(nx, ny, cur.dist + 1, cur.breakCnt));
					visited[nx][ny][cur.breakCnt] = true;
				} else if (cur.breakCnt < K && !visited[nx][ny][cur.breakCnt + 1] && !map[nx][ny]) {
					queue.add(new Node(nx, ny, cur.dist + 1, cur.breakCnt + 1));
					visited[nx][ny][cur.breakCnt + 1] = true;					
				}
			}
		}
		
		return -1;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
