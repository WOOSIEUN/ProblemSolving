import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1520 {

	static int M, N;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map, route;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int [M][N];
		route = new int [M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				route[i][j] = -1;
			}
		}
		bw.write(String.valueOf(dfs(0, 0)));
		br.close();
		bw.close();
	}
	
	private static int dfs(int x, int y) {
		if (x == M - 1 && y == N - 1) {
			return 1;
		}
		if (route[x][y] != -1) {
			return route[x][y];
		}
		route[x][y] = 0;
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if (isInMap(nx, ny) && map[x][y] > map[nx][ny]) {
				route[x][y] += dfs(nx, ny);
			}
		}
		return route[x][y];
	}
	
	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}
