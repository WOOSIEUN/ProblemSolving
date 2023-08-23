import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2468 {
	
	static int N;
	static int[][] map, dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;
		int maxHeight = 0;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		for (int height = 0; height <= maxHeight; height++) {
			int cnt = 0;
			visited = new boolean [N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > height) {
						cnt += getSafeArea(i, j, height);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}		
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static int getSafeArea(int x, int y, int height) {
		visited[x][y] = true;
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if (isInMap(nx, ny) && !visited[nx][ny] && map[nx][ny] > height) {
				getSafeArea(nx, ny, height);
			}
		}
		return 1;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}