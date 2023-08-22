import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14503 {
	
	static int ans, N, M, robotVacuumX, robotVacuumYm, robotVacuumDir;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] blankSpace, visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		blankSpace = new boolean [N][M];
		visited = new boolean [N][M];
		
		st = new StringTokenizer(br.readLine());
		int robotVacuumX = Integer.parseInt(st.nextToken());
		int robotVacuumYm = Integer.parseInt(st.nextToken());
		int robotVacuumDir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				blankSpace[i][j] = (Integer.parseInt(st.nextToken()) == 0 ? true : false);
			}
		}
		
		cleanRoom(robotVacuumX, robotVacuumYm, robotVacuumDir);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static void cleanRoom(int x, int y, int dir) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			ans++;
		}
		
		int ndir = dir;
		for (int i = 0; i < 4; i++) {
			ndir = (ndir + 3) % 4;
			int nx = x + dirs[ndir][0];
			int ny = y + dirs[ndir][1];
			if (isInMap(nx, ny) && blankSpace[nx][ny] && !visited[nx][ny]) {
				cleanRoom(nx, ny, ndir);
				return;
			}
		}
		
		ndir = (dir + 2) % 4;
		int nx = x + dirs[ndir][0];
		int ny = y + dirs[ndir][1];
		if (isInMap(nx, ny) && blankSpace[nx][ny]) {
			cleanRoom(nx, ny, dir);
		}
	}
	
	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
