import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17070 {
	
	static int N, answer;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 2, 0);
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void dfs(int x, int y, int type) {
		if (x == N && y == N) {
			answer++;
			return;
		}
		
		if (isInMap(x + 1, y + 1) && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
		
		if (type == 0) {
			if (isInMap(x, y + 1) && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
		} else if (type == 1) {
			if (isInMap(x + 1, y) && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		} else {
			if (isInMap(x, y + 1) && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (isInMap(x + 1, y) && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			} 
		}
	}

	private static boolean isInMap(int x, int y) {
		return 0 < x && x < N + 1 && 0 < y && y < N + 1;
	}
}
