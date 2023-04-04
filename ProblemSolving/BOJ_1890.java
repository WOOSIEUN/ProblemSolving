import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1890 {

	static int N;
	static int[][] dirs = {{1, 0}, {0, 1}};
	static int[][] map;
	static long[][] route;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		route = new long [N][N];
		for (int i = 0; i < N; i++) {
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
	
	private static long dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			return 1;
		}
		if (route[x][y] != -1) {
			return route[x][y];
		}
		route[x][y] = 0;
		for (int[] dir : dirs) {
			int nx = x + dir[0] * map[x][y];
			int ny = y + dir[1] * map[x][y];
			if (isInMap(nx, ny)) {
				route[x][y] += dfs(nx, ny);
			}
		}
		return route[x][y];
	}
	
	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
