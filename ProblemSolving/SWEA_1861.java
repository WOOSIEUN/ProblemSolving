import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int N, max, maxStart, nx, ny;
	static int [][] map;
	static boolean[][] isVisited;
	static int [][] dirs = {{-1, 0}, {0, -1},{1, 0},{0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			map = new int [N][N];
			isVisited = new boolean [N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++)
					dfs(1, i, j, map[i][j]);
			sb.append("#").append(t).append(" ").append(maxStart).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void dfs(int depth, int x, int y, int start) {
		isVisited[x][y] = true;
		for (int[] dir : dirs) {
			nx = x + dir[0];
			ny = y + dir[1];
			if(isInMap(nx, ny) && !isVisited[nx][ny] && map[nx][ny] == map[x][y] + 1)
				dfs(depth + 1, nx, ny, start);
		}
		if(depth > max) {
			max = depth;
			maxStart = start;
		}
		if(depth == max) maxStart = Math.min(maxStart, start);
		isVisited[x][y] = false;
	}

	public static boolean isInMap(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}	
}
