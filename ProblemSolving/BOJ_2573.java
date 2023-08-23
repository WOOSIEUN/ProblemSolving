import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static class Iceberg {
		int x, y;
		public Iceberg(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, ans;
	static int[][] map, nextMap, dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static boolean[][] visited;
	static Queue<Iceberg> icebergs = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					icebergs.add(new Iceberg(i, j));
				}
			}
		}
		
		int numOfIceberg;
		while ((numOfIceberg = getNumOfIceberg()) < 2) {
			if (numOfIceberg == 0) {
				ans = 0;
				break;
			}
			nextMap = new int [N][M];
			meltIceberg();
			copyMap(nextMap, map);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static int getNumOfIceberg() {
		int numOfIceberg = 0;
		visited = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					findIceberg(i, j);
					numOfIceberg++;
				}
			}
		}
		return numOfIceberg;
	}

	private static void findIceberg(int x, int y) {
		visited[x][y] = true;
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if (isInMap(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
				findIceberg(nx, ny);
			}
		}		
	}

	private static void meltIceberg() {
		int icebergsLen = icebergs.size();
		for (int i = 0; i < icebergsLen; i++) {
			Iceberg cur = icebergs.poll();
			int numOfSea = 0;
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				if (isInMap(nx, ny) && map[nx][ny] == 0) {
					numOfSea++;
				}
			}
			int newIcebergHeight = (map[cur.x][cur.y] - numOfSea > 0) ? map[cur.x][cur.y] - numOfSea : 0;
			nextMap[cur.x][cur.y] = newIcebergHeight;
			if (newIcebergHeight != 0) {
				icebergs.add(new Iceberg(cur.x, cur.y));
			}
		}
		ans++;
	}

	private static void copyMap(int[][] src, int[][] des) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				des[i][j] = src[i][j];
			}
		}
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
